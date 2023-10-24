package com.example.springevents.asynchronous;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

// Indicate that this class is a source of bean definitions
@Configuration
// Scan the specified package for Spring components
@ComponentScan("com.example.springevents.synchronous")
public class AsynchronousSpringEventsConfig {
    // Define a bean for the ApplicationEventMulticaster, which is an interface for multicasting Spring application events
    @Bean(name = "applicationEventMulticaster")
    public ApplicationEventMulticaster simpleApplicationEventMulticaster() {
        // Create a SimpleApplicationEventMulticaster, which is a concrete implementation of ApplicationEventMulticaster
        final SimpleApplicationEventMulticaster simpleApplicationEventMulticaster =
                new SimpleApplicationEventMulticaster();
        // Set the TaskExecutor that will actually execute listeners for each event
        simpleApplicationEventMulticaster.setTaskExecutor(new SimpleAsyncTaskExecutor());
        return simpleApplicationEventMulticaster;
    }
}

