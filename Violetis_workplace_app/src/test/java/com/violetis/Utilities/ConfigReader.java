package com.violetis.Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
	 private static Properties properties;
	 private static final Logger log = LogManager.getLogger(ConfigReader.class);
	 static {
	        try {
	            log.info("Loading config.properties file...");
	            FileInputStream fis = new FileInputStream(
	                    "C:\\VIOLETIS\\VIOLETIS_WORKPLACE_APP\\VIOLETIS_WORKPLACEAPP\\src\\main\\Resources\\Config.properties"
	            );
	            properties = new Properties();
	            properties.load(fis);
	            log.info("config.properties file loaded successfully.");
	        } catch (IOException e) {
	            log.error("❌ Failed to load config.properties file!", e);
	            throw new RuntimeException("Failed to load config.properties file!", e);
	        }
	    }

	    // Method to get property by key
	    public static String getProperty(String key) {
	        String value = properties.getProperty(key);
	        if (value == null) {
	            log.warn("⚠️ Property '{}' not found in config.properties.", key);
	        } else {
	            log.debug("Property '{}' = {}", key, value);
	        }
	        return value;
	    }
}
