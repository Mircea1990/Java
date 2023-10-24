package com.example.spring.patterns.factory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This annotation indicates that this class is a source of bean definitions
@Configuration
// This annotation sets up a component scan which allows Spring to auto-detect other components,
// configurations and services in the same package or below
@ComponentScan(basePackageClasses = ApplicationConfig.class) public class ApplicationConfig {
    // This class doesn't have any methods or fields as it is used only for configuration purposes
}

