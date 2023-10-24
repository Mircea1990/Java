package com.example.applicationcontext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation indicates that this class declares one or more @Bean methods and
// may be processed by the Spring container to generate bean definitions and service requests for
// those beans at runtime.
@Configuration
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the
// packages to scan for annotated components.
// "com.example.applicationcontext" is the package to scan.
@ComponentScan("com.example.applicationcontext") public class TestContextConfig {
    // This class doesn't have any methods or fields.
    // It is used only for configuration, specifically, it instructs Spring to scan the "com
    // .example.applicationcontext" package for components.
}

