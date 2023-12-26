package helpers;

import utils.LogUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;
    private static String linkFile;
    private static FileInputStream file;
    private static FileOutputStream out;
    private static String relPropertiesFilePathDefault = "src/test/resources/configs/configs.properties";
    public static Properties loadAllFiles() {
        LinkedList<String> files = new LinkedList<>();
        files.add("src/test/resources/configs/configs.properties");
        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemHelper.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }
    public static Properties loadLive() {
        LinkedList<String> files = new LinkedList<>();
        files.add("src/test/resources/configs/configs.properties");
        files.add("src/test/resources/configs/live.properties");
        files.add("src/test/resources/configs/locale.properties");
        files.add("src/test/resources/configs/token.properties");
        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemHelper.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }
    public static Properties loadSat() {
        LinkedList<String> files = new LinkedList<>();
        files.add("src/test/resources/configs/token.properties");
        files.add("src/test/resources/configs/configs.properties");
        files.add("src/test/resources/configs/sat.properties");
        files.add("src/test/resources/configs/locale.properties");
        try {
            properties = new Properties();

            for (String f : files) {
                Properties tempProp = new Properties();
                linkFile = SystemHelper.getCurrentDir() + f;
                file = new FileInputStream(linkFile);
                tempProp.load(file);
                properties.putAll(tempProp);
            }
            return properties;
        } catch (IOException ioe) {
            return new Properties();
        }
    }

    public static void setFile(String relPropertiesFilePath) {
        properties = new Properties();
        try {
            linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePath;
            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
            System.out.println("Set Properties file: " + relPropertiesFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setDefaultFile() {
        properties = new Properties();
        try {
            linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePathDefault;

            file = new FileInputStream(linkFile);
            properties.load(file);
            file.close();
            LogUtils.info("Set default Properties file: " + relPropertiesFilePathDefault);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        String value = null;
        try {
            if (file == null) {
                properties = new Properties();
                linkFile = SystemHelper.getCurrentDir() + relPropertiesFilePathDefault;
                file = new FileInputStream(linkFile);
                properties.load(file);
                file.close();
            }
            // Lấy giá trị từ file đã Set
            value = properties.getProperty(key);
        } catch (Exception e) {
            LogUtils.warn(e.getMessage());
        }
        return value;
    }

    public static void setValue(String key, String value) {
        try {
            if (file == null) {
                properties = new Properties();
                file = new FileInputStream(SystemHelper.getCurrentDir() + relPropertiesFilePathDefault);
                properties.load(file);
                file.close();
                out = new FileOutputStream(SystemHelper.getCurrentDir() + relPropertiesFilePathDefault);
            }
            //Ghi vào cùng file Prop với file lấy ra
            out = new FileOutputStream(linkFile);
            System.out.println(linkFile);
            properties.setProperty(key, value);
            properties.store(out, null);
            out.close();
            LogUtils.info("Set " + key + " = " + value + " to properties file successfully.");
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }
    }

}
