package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static String READ(String key) {
        return READ(key, Constants.CONFIG_FILE_PATH);
    }

    public static String READ(String key, String path) {

        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties.getProperty(key);
    }


}

