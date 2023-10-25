package com.example.spring43.depresolution;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration is a Spring annotation that indicates the class can be used by the Spring IoC
// container as a source of bean definitions.
@Configuration

// @ComponentScan is another Spring annotation that tells Spring to scan and bootstrap other
// components defined in the current package or below.
@ComponentScan

// ObjectProviderConfiguration is the name of the class. This class is now a configuration class
// that can provide beans and also trigger auto-detection of Spring components.
public class ObjectProviderConfiguration {}
