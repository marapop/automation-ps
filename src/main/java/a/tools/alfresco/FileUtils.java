package a.tools.alfresco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import junit.framework.Assert;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileExistsException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("deprecation")
public class FileUtils {

    public static File downloadFile(String fileUrl, String destinationFile) {
        URL url = null;
        try {
            url = new URL(fileUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = url.openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream os = null;
        File file = new File(destinationFile);
        try {
            os = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] b = new byte[2048];
        int length;
        try {
            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public static File createFile(String fileName) {
        File file = new File(fileName);
        try {
            boolean fileDidntExist = file.createNewFile();
            Assert.assertTrue(
                    "A file named '" + fileName + "' already exists!",
                    fileDidntExist);
        } catch (IOException e) {
            Assert.fail("The file named '" + fileName
                    + "' was not created successfully!");
        }
        return file;
    }

    public static File createFile(String fileName, String fileContent) {
        File file = createFile(fileName);
        writeToFile(fileName, fileContent);
        return file;
    }

    public static void deleteFileOrDirectory(File file) {
        try {
            if (file.exists())
                FileDeleteStrategy.FORCE.delete(file);
        } catch (Exception e) {
            Assert.fail("The file named '" + file.getName()
                    + "' was not deleted successfully!");
        }
    }

    public static void deleteFileOrDirectory(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists())
                FileDeleteStrategy.FORCE.delete(file);
        } catch (Exception e) {
            Assert.fail("The file named '" + filePath
                    + "' was not deleted successfully!");
        }
    }

    public static void cleanDirectory(String directoryPath) {
        try {
            File directory = new File(directoryPath);
            if (directory.exists())
                org.apache.commons.io.FileUtils.cleanDirectory(directory);
        } catch (Exception e) {
            Assert.fail("The directory named '" + directoryPath
                    + "' was not cleaned successfully!");
        }
    }

    public static void deleteFilesContainingStringsInNameFromDirectory(
            String directoryPath, String... searchedTerms) {
        try {
            File directory = new File(directoryPath);
            if (directory.exists())
                for (File file : directory.listFiles()) {
                    if (file.isFile()) {
                        boolean matched = true;
                        String fileName = file.getName().toLowerCase();
                        for (String term : searchedTerms) {
                            if (!fileName.contains(term.toLowerCase())) {
                                matched = false;
                                break;
                            }
                        }
                        if (matched)
                            FileDeleteStrategy.FORCE.delete(file);
                    }
                }
        } catch (Exception e) {
        }
    }

    public static File createDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        if (!dir.exists())
            dir.mkdir();
        return dir;
    }

    public static String readFromFile(String filePath) {
        File file = new File(filePath);
        Assert.assertTrue("No file with path '" + filePath + "' exists!",
                file.exists());
        int ch;
        StringBuffer strContent = new StringBuffer("");
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(file);
            while ((ch = fin.read()) != -1)
                strContent.append((char)ch);
            fin.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strContent.toString();
    }

    public static String getCurrentUserPath() {
        return System.getProperty("user.home");
    }

    public static String getProjectPath() {
        return new File("").getAbsolutePath();
    }

    public static void writeToFile(String filePath, String fileContent) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
            out.write(fileContent);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendLinesToFile(String filePath, String... lines) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
                    filePath), true));
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Moves the provided file to the desired folder and creates the destination folder if necessary
     * 
     * @param srcFilePath
     * @param destDirPath
     * @param createDestDir
     */
    public static void moveFileToDirectory(String srcFilePath,
            String destDirPath, boolean createDestDir) {
        try {
            org.apache.commons.io.FileUtils.moveFileToDirectory(new File(
                    srcFilePath), new File(destDirPath), true);
        } catch (NullPointerException e1) {
            e1.printStackTrace();
            Assert.fail("The source or the destination folder is null!");
        } catch (FileExistsException e2) {
            e2.printStackTrace();
            Assert.fail("A file with the same name already exists in the destination folder!");
        } catch (IOException e3) {
            e3.printStackTrace();
            Assert.fail("The source or the destination folder is invalid or an IO error occured while moving the file!");
        }
    }

    public static File waitForFileToFinishDownloading(String srcFilePath,
            int waitingTime, int noOfRetries) {
        File ff = new File(srcFilePath);
        if (!ff.exists())
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if (ff.exists()) {
            for (int timeout = noOfRetries; timeout > 0; timeout--) {
                RandomAccessFile ran = null;
                try {
                    ran = new RandomAccessFile(ff, "rw");
                    break; // no errors, done waiting
                } catch (Exception ex) {
                } finally {
                    if (ran != null)
                        try {
                            ran.close();
                        } catch (IOException ex) {
                        }
                    ran = null;
                }
                try {
                    Thread.sleep(waitingTime); // wait a bit then try again
                } catch (InterruptedException ex) {
                }
            }
        }
        return ff;
    }

    public static File getMostRecentFile(List<File> fielsList) {
        Date mostRecentFileDate = new Date(
                fielsList.get(0).lastModified() * 1000);
        File mostRecentFile = fielsList.get(0);
        for (int i = 1; i < fielsList.size(); i++) {
            File currentFile = fielsList.get(i);
            Date currentFileDate = new Date(currentFile.lastModified() * 1000);
            if (currentFileDate.compareTo(mostRecentFileDate) > 0) {
                mostRecentFileDate = currentFileDate;
                mostRecentFile = currentFile;
            }
        }
        return mostRecentFile;
    }

    /**
     * Searches for files containing the provided terms in the name from the provided directory and returns a list of matching files
     * 
     * @param directoryPath
     * @param extensions
     * @param recursive
     * @param searchedTerms
     * @return
     */
    public static List<File> searchFileRecursively(String directoryPath,
            String[] extensions, boolean recursive, String... searchedTerms) {
        File directory = new File(directoryPath);
        Assert.assertFalse("The provided directory '" + directoryPath
                + "' is a file!", directory.isFile());
        List<File> matchingFiles = new ArrayList<File>();

        try {
            Collection<File> files = org.apache.commons.io.FileUtils.listFiles(
                    directory, extensions, recursive);
            for (Iterator<File> iterator = files.iterator(); iterator.hasNext();) {
                File file = (File)iterator.next();
                boolean matched = true;
                String fileName = file.getName().toLowerCase();
                for (String term : searchedTerms) {
                    if (!fileName.contains(term.toLowerCase())) {
                        matched = false;
                        break;
                    }
                }
                if (matched)
                    matchingFiles.add(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue("No matching file was found in the directory '"
                + directoryPath + "'!", matchingFiles.size() > 0);
        return matchingFiles;
    }

    /**
     * Reads a file line by line and returns a list with the file lines
     * 
     * @param filePath
     * @return
     */
    public static List<String> getFileLinesAsList(String filePath) {
        List<String> fileLines = new ArrayList<String>();
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                while (br.ready()) {
                    String line = br.readLine();
                    fileLines.add(line);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                Assert.fail("An IOException has occured while reading the file!");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Assert.fail("A FileNotFoundException has occured while reading the file!");
        }
        return fileLines;
    }

    public static List<List<String>> getExcelContent(String filePath) {
        List<List<String>> myXMLMatrix = new ArrayList<List<String>>();
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(filePath));
            doc.getDocumentElement().normalize();
            NodeList listRows = doc.getElementsByTagName("Export");
            for (int r = 1; r < listRows.getLength(); r++) {
                NodeList listCells = listRows.item(r).getChildNodes();
                List<String> cells = new ArrayList<String>();
                for (int c = 0; c < listCells.getLength(); c++) {
                    Node data = listCells.item(c);
                    cells.add(data.getTextContent());
                }
                myXMLMatrix.add(cells);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return myXMLMatrix;
    }

	public static List<List<String>> getXLSXTypeExcelContent(
			String absolutePath, int i) {
		return null;
	}
}
