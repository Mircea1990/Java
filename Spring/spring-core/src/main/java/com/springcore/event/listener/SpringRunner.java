package com.springcore.event.listener;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// This is the main class that will run the Spring application.
public class SpringRunner {
    // The main method is the entry point for the application.
    public static void main(String[] args) {
        // This line creates a new Spring application context from the configuration provided by the EventConfig class.
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(EventConfig.class);
        // This line starts the Spring application context.
        ctx.start();
    }
}

