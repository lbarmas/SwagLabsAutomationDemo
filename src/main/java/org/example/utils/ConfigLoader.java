package org.example.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;

    public ConfigLoader() throws Exception {
        properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("config.properties");
        properties.load(fileInputStream);
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
