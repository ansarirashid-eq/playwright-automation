package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ConfigReader {
    private static final Properties PROPS = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            PROPS.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        public static String get(String key){
            return PROPS.getProperty(key);
        }
    }
