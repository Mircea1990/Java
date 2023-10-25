package com.example.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The @SpringBootApplication annotation is a convenience annotation that adds all of the following:
// @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
// other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the
// 'com/example' package, allowing it to find the controllers.
@SpringBootApplication public class SpringBoot {

    // The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
    public static void main(String[] args) {
        // The SpringApplication.run() method starts the whole Spring Framework. It returns an
        // ApplicationContext where all the beans (services, repositories, controllers) are
        // initialized and ready to use.
        SpringApplication.run(SpringBoot.class, args);
    }
}

