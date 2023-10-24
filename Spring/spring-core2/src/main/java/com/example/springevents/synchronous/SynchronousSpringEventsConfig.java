package com.example.springevents.synchronous;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation indicates that this class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
@Configuration
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the packages to scan for annotated components.
// "com.example.springevents.synchronous" is the package to scan.
@ComponentScan("com.example.springevents.synchronous")
public class SynchronousSpringEventsConfig {
    // This class doesn't have any methods or fields.
    // It is used only for configuration, specifically, it instructs Spring to scan the "com.example.springevents.synchronous" package for components.
}

