package com.springcore.event.listener;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This annotation indicates that this class provides configuration for the application.
@Configuration
// This annotation is used to specify the packages to be scanned for components. In this case, it's scanning the package "com.springcore.event.listener".
@ComponentScan(basePackages = "com.springcore.event.listener")
public class EventConfig {
}

