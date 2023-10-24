package com.example.reinitializebean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The @SpringBootApplication annotation is used to mark the main class of a Spring Boot application
@SpringBootApplication
public class ReinitializeBeanApp {
    // The main method is the entry point of the application
    public static void main(String[] args) {
        // SpringApplication.run method launches the application
        SpringApplication.run(ReinitializeBeanApp.class, args);
    }
}

