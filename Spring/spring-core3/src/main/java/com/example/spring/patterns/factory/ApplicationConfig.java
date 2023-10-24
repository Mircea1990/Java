package com.example.spring.patterns.factory;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation is used to indicate that the class declares one or more @Bean
// methods
// and may be processed by the Spring container to generate bean definitions and service requests
// for those beans at runtime.
@Configuration
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the
// packages to scan for annotated components.
// basePackageClasses allows for type-safe specification of the package to scan.
@ComponentScan(basePackageClasses = ApplicationConfig.class)
// This is your configuration class named 'ApplicationConfig'.
public class ApplicationConfig {}

