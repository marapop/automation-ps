package a.tools.alfresco;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Iterator;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.lang3.RandomStringUtils;

public final class RandomGenerators {

    public static SecureRandom random = new SecureRandom();

    public static String getRandomString(String prefix, int length) {
        return prefix + RandomStringUtils.randomAlphabetic(length);
    }

    public static String getRandomString(int length, String sufix) {
        return RandomStringUtils.randomAlphabetic(length) + sufix;
    }

    public static Integer getRandomInteger(int max) {
        return Math.abs(random.nextInt(max));
    }

    /**
     * Generates a random integer between the min and max values including
     * 
     * @param min
     * @param max
     * @return
     */
    public static Integer getRandomIntegerBetween(int min, int max) {
        int result = random.nextInt(max + 1);
        return (result >= min ? result : result + min);

    }

    public static String getRandomString() {
        String rndStr = new BigInteger(100, random).toString(32);
        return rndStr;
    }

    public static String getRandomString(int length) {
        return getRandomString().substring(0, length);
    }

    public static Double getRandomDouble(int max) {
        return Math.abs(random.nextDouble() * max);
    }

    public static Double getRandomDouble(double max) {
        return Math.abs(random.nextDouble() * max);
    }

    public static Double getRandomDoubleBetween(int min, int max) {
        double result = random.nextDouble();
        return result * (max - min) + min;
    }

    public static Integer getRandomIntegerOfLength(Integer length) {
        String integerPart = RandomStringUtils.randomNumeric(length);
        if (integerPart.charAt(0) == '0')
            integerPart = getRandomIntegerBetween(1, 9)
                    + integerPart.substring(1);
        return Integer.parseInt(integerPart);
    }

    public static Long getRandomLongOfLength(Integer length) {
        String integerPart = RandomStringUtils.randomNumeric(length);
        if (integerPart.charAt(0) == '0')
            integerPart = getRandomIntegerBetween(1, 9)
                    + integerPart.substring(1);
        return Long.valueOf(integerPart);
    }

    public static Long getRandomLongOfLength(long prefix, Integer length) {
        return Long.valueOf(prefix + RandomStringUtils.randomNumeric(length));
    }

    public static Double getRandomDoubleOfLength(int integerLength,
            int decimalLength) {
        String integerPart = RandomStringUtils.randomNumeric(integerLength);
        if (integerLength > 0 && integerPart.charAt(0) == '0')
            integerPart = getRandomIntegerBetween(1, 9)
                    + integerPart.substring(1);
        String decimalPart = RandomStringUtils.randomNumeric(decimalLength);
        return MathUtils.getDoubleWithTwoDigits(Double.parseDouble(integerPart
                + "." + decimalPart));
    }

    public static File createRandomImage(String fileName, int width,
            int height, int pixelSize, String fileType) {
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g = (Graphics2D)bi.getGraphics();
        for (int x = 0; x < width / pixelSize; x++) {
            for (int y = 0; y < height / pixelSize; y++) {
                g.setColor(new Color(random.nextInt(255), random.nextInt(255),
                        random.nextInt(255)));
                g.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
            }
        }
        g.dispose();
        return saveImageToFile(bi, fileName, fileType);
    }

    public static File saveImageToFile(BufferedImage img, String fileName,
            String fileType) {
        ImageWriter writer = null;
        File file = new File(fileName + "." + fileType);
        Iterator<ImageWriter> iterator = ImageIO
                .getImageWritersByFormatName(fileType);
        if (iterator.hasNext()) {
            writer = iterator.next();
        }
        ImageOutputStream ios = null;
        try {
            ios = ImageIO.createImageOutputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.setOutput(ios);
        ImageWriteParam param = new JPEGImageWriteParam(
                java.util.Locale.getDefault());
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.98f);
        try {
            writer.write(null, new IIOImage(img, null, null), param);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ios.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
