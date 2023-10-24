package com.example.concurrentrequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The @SpringBootApplication annotation is a convenience annotation that adds all of the following:
// @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the current package, allowing it to find controllers.
@SpringBootApplication
public class ConcurrentRequestApplication {
    // The main method serves as an entry point for the application.
    public static void main(String[] args) {
        // The SpringApplication.run method launches an application. Here it's launching the ConcurrentRequestApplication.
        SpringApplication.run(ConcurrentRequestApplication.class, args);
    }
}

