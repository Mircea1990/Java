package com.example.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This class is marked as a configuration class. It defines methods to instantiate and configure
// the dependencies.
@Configuration public class FactoryBeanAppConfig {
    // This method is marked with @Bean annotation which means it will be instantiated,
    // assembled, and managed by Spring IoC container.
    // The name of the bean is "tool". It returns a ToolFactory object.
    @Bean(name = "tool") public ToolFactory toolFactory() {
        // Creating a new instance of ToolFactory
        ToolFactory factory = new ToolFactory();
        // Setting the factoryId of the ToolFactory instance
        factory.setFactoryId(7070);
        // Setting the toolId of the ToolFactory instance
        factory.setToolId(2);
        // Returning the configured ToolFactory instance
        return factory;
    }
}
