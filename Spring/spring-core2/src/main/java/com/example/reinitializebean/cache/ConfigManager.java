package com.example.reinitializebean.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// The @Service annotation is used to mark the class as a service provider
@Service("ConfigManager")
public class ConfigManager {
    // LOG is a static final Log instance used for logging
    private static final Log LOG = LogFactory.getLog(ConfigManager.class);
    // filePath is a String that stores the path of the configuration file
    private final String filePath;
    // config is a Map that will store the configuration key-value pairs
    private Map<String, Object> config;

    // Constructor for ConfigManager which takes a file path as input
    public ConfigManager(@Value("${config.file.path}") String filePath) {
        this.filePath = filePath;
        // Calls the initConfigs method to initialize the configurations
        initConfigs();
    }

    // Method to initialize configurations from the file at filePath
    private void initConfigs() {
        Properties properties = new Properties();
        try {
            // Load properties from the file
            properties.load(Files.newInputStream(Paths.get(filePath)));
        } catch (IOException e) {
            // Log an error message if there's an issue loading the configuration
            LOG.error("Error loading configuration:", e);
        }
        config = new HashMap<>();
        // Loop through each entry in properties and add it to the config map
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            config.put(String.valueOf(entry.getKey()), entry.getValue());
        }
    }

    // Method to get a configuration value by its key
    public Object getConfig(String key) {
        return config.get(key);
    }

    // Method to reinitialize configurations by calling initConfigs again
    public void reinitializeConfig() {
        initConfigs();
    }
}

