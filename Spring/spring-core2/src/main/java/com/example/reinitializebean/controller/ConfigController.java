package com.example.reinitializebean.controller;

import com.example.reinitializebean.cache.ConfigManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// The @RestController annotation is used to mark the class as a RESTful Web Service
@RestController
// The @RequestMapping annotation is used to map web requests onto specific handler classes
// and/or handler methods
@RequestMapping("/config") public class ConfigController {
    // ApplicationContext is an interface for providing configuration information to an application
    private final ApplicationContext applicationContext;
    // ConfigManager is a class that manages configurations for an application
    private final ConfigManager configManager;
    // filePath is a String that stores the path of the configuration file
    @Value("${config.file.path}") private String filePath;

    // Constructor for ConfigController which takes an ApplicationContext and a ConfigManager as
    // inputs
    public ConfigController(ApplicationContext applicationContext, ConfigManager configManager) {
        this.applicationContext = applicationContext;
        this.configManager = configManager;
    }

    // Method to reinitialize configurations by calling reinitializeConfig method of configManager
    @GetMapping("/reinitializeConfig") public void reinitializeConfig() {
        configManager.reinitializeConfig();
    }

    // Method to reinitialize the ConfigManager bean in the application context
    @GetMapping("/reinitializeBean") public void reinitializeBean() {
        DefaultSingletonBeanRegistry registry =
                (DefaultSingletonBeanRegistry) applicationContext.getAutowireCapableBeanFactory();
        registry.destroySingleton("ConfigManager");
        registry.registerSingleton("ConfigManager", new ConfigManager(filePath));
    }

    // Method to destroy the ConfigManager bean in the application context
    @GetMapping("/destroyBean") public void destroyBean() {
        DefaultSingletonBeanRegistry registry =
                (DefaultSingletonBeanRegistry) applicationContext.getAutowireCapableBeanFactory();
        registry.destroySingleton("ConfigManager");
    }

    // Method to get a configuration value by its key by calling getConfig method of configManager
    @GetMapping("/{key}") public Object get(@PathVariable String key) {
        return configManager.getConfig(key);
    }

    // Method to get a configuration value by its key from the application context
    @GetMapping("/context/{key}") public Object getFromContext(@PathVariable String key) {
        ConfigManager dynamicConfigManager = applicationContext.getBean(ConfigManager.class);
        return dynamicConfigManager.getConfig(key);
    }
}

