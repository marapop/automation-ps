package a.steps.alfresco;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.junit.Assert;

import a.tools.alfresco.AlfrescoHttpHelper;
import a.tools.alfresco.Constants;

public class AlfrescoStepsAlfHttpApi {

	private AlfrescoHttpHelper alfHttp = new AlfrescoHttpHelper();

	private String nodeRef;

	public void iDeleteASiteNamed(String siteName) {
		System.out.print("Deleting site " + siteName + " ... ");
		try {
			alfHttp.deleteSite(siteName);
		} catch (Exception e) {
			System.out.println("Delete site: " + e.getMessage());
		}
	}

	public void iHaveAXXCollection(int arg1, int arg2, int arg3) throws Exception {
		String siteName = "auto6x10x100";
		System.out.println("Create a big collection ... start");

		String nodeRef = alfHttp.createContainer("Collection", Constants.TYPE_FOLDER, siteName);
		alfHttp.addAspects(nodeRef, Collections.singletonList(Constants.ASPECT_COLLECTABLE));

		for (int i = 1; i <= arg1; i++) {
			String chapterName = "Chapter" + String.valueOf(i);
			System.out.println(chapterName);
			nodeRef = alfHttp.createContainer(chapterName, Constants.TYPE_FOLDER, siteName, "/Collection");
			alfHttp.addAspects(nodeRef, Collections.singletonList(Constants.ASPECT_COLLECTABLE));
			for (int j = 1; j <= arg2; j++) {
				String subChapterName = "Ch" + String.valueOf(i) + "_SubCh" + String.valueOf(j);
				System.out.println(subChapterName);
				nodeRef = alfHttp.createContainer(subChapterName, Constants.TYPE_FOLDER, siteName, "/Collection/" + chapterName);
				alfHttp.addAspects(nodeRef, Collections.singletonList(Constants.ASPECT_COLLECTABLE));
				for (int k = 1; k <= arg3; k++) {
					System.out.println("Ch" + String.valueOf(i) + "SubCh" + String.valueOf(j) + "File" + String.valueOf(k));
					alfHttp.uploadFile(siteName, "test" + String.valueOf(k) + ".txt", "/Collection/" + chapterName + "/" + subChapterName);
				}
			}
		}

		System.out.println("Create a big collection ... end");
	}

	public static Collection<String> getResourcesFromDirectory(File directory, Pattern pattern) {
		final ArrayList<String> retval = new ArrayList<String>();
		final File[] fileList = directory.listFiles();
		for (final File file : fileList) {
			if (file.isDirectory()) {
				retval.addAll(getResourcesFromDirectory(file, pattern));
			} else {
				try {
					final String fileName = file.getCanonicalPath();
					final boolean accept = pattern.matcher(fileName).matches();
					if (accept) {
						retval.add(fileName);
					}
				} catch (final IOException e) {
					throw new Error(e);
				}
			}
		}
		return retval;
	}

	public void I_upload_all_files_from_with_path_in_a_site_named(String resourcesPath, String path, String site) throws Exception {
		// Express the Regexp above with the code you wish you had
		// throw new PendingException();

		File directory = new File(Constants.TESTDATA_FILES_BASE_PATH + resourcesPath);

		File[] fileList = directory.listFiles();

		for (File file : fileList) {
			System.out.println(resourcesPath + "\\" + file.getName());
			nodeRef = alfHttp.uploadFileFromCustomFolder(site, resourcesPath + "\\" + file.getName(), path);
		}
	}

	public void createBaseCollection(String collectionName, String site) throws Exception {
		nodeRef = alfHttp.createContainer(collectionName, Constants.TYPE_FOLDER, site);
		alfHttp.addAspects(nodeRef, Collections.singletonList(Constants.ASPECT_COLLECTABLE));
	}

	public void createChildCollection(String collectionName, String path, String site) throws Exception {
		nodeRef = alfHttp.createContainer(collectionName, Constants.TYPE_FOLDER, site, path);
		alfHttp.addAspects(nodeRef, Collections.singletonList(Constants.ASPECT_COLLECTABLE));
	}

	public void createBaseFolder(String folderName, String site) throws Exception {
		nodeRef = alfHttp.createContainer(folderName, Constants.TYPE_FOLDER, site);
	}

	public void createFolder(String folderName, String path, String site) throws Exception {
		nodeRef = alfHttp.createContainer(folderName, Constants.TYPE_FOLDER, site, path);
	}
	
	public void createFolder(String folderName, String path, String site, String type) throws Exception {
		nodeRef = alfHttp.createContainer(folderName, type, site, path);
	}

	public void uploadFile(String fileName, String path, String site) throws Exception {
		nodeRef = alfHttp.uploadFile(site, fileName, path);
	}

	public void uploadFile(int numberOfFiles, String fileName, String path, String site) throws Exception {
		for (int i = 0; i < numberOfFiles; i++) {
			nodeRef = alfHttp.uploadFile(site, fileName, path);
		}
	}

	public void createComment(String title, String content) throws Exception {
		alfHttp.createComment(title, content, nodeRef);
	}

	public void createTag(String tag) throws Exception {
		alfHttp.createTag(tag, nodeRef);
	}
	
	public void node_should_not_be_under_path_and_site(String node, String path, String site) throws JSONException, Exception {
		Assert.assertFalse("Node should not be present: ", alfHttp.getChildren(site, path).contains(">"+node+"<"));
		
	}
}
