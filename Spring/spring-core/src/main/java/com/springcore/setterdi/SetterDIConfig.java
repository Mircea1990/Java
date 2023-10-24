package com.springcore.setterdi;

import com.springcore.setterdi.domain.Engine;
import com.springcore.setterdi.domain.Trailer;
import com.springcore.setterdi.domain.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// This is a configuration class for Spring Framework
@Configuration
// This annotation is used with @Configuration to allow Spring to automatically scan the classes of specified packages
@ComponentScan("com.springcore.setterdi")
public class SetterDIConfig {
    // This method is annotated with @Bean, meaning it will be instantiated, assembled, and managed by Spring IoC container
    @Bean
    public Engine engine() {
        // Creating a new Engine object
        Engine engine = new Engine();
        // Setting the type of the engine to "v8"
        engine.setType("v8");
        // Setting the volume of the engine to 2
        engine.setVolume(2);
        // Returning the configured Engine object
        return engine;
    }

    // This method is annotated with @Bean, meaning it will be instantiated, assembled, and managed by Spring IoC container
    @Bean
    public Transmission transmission() {
        // Creating a new Transmission object
        Transmission transmission = new Transmission();
        // Setting the type of the transmission to "CVT"
        transmission.setType("CVT");
        // Returning the configured Transmission object
        return transmission;
    }

    // This method is annotated with @Bean, meaning it will be instantiated, assembled, and managed by Spring IoC container
    @Bean
    public Trailer trailer() {
        // Creating a new Trailer object
        Trailer trailer = new Trailer();
        // Returning the Trailer object
        return trailer;
    }
}
