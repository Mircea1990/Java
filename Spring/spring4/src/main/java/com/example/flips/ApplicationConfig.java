package com.example.flips;

import org.flips.describe.config.FlipWebContextConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Import;

// The @SpringBootApplication annotation is a convenience annotation that adds all of the following:
// @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
// other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the
// 'com/example' package, allowing it to find the controllers.
// The 'exclude' parameter is used to exclude certain auto-configuration classes such that they
// will not be applied.
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})

// The @Import annotation allows for loading @Bean definitions from another configuration class.
// Here it's loading bean definitions from the 'FlipWebContextConfiguration' class.
@Import(FlipWebContextConfiguration.class)

public class ApplicationConfig {
    // The main method uses Spring Boot’s SpringApplication.run() method to launch an application.
    // Here we are passing the 'ApplicationConfig' class as an argument to the run method to tell
    // SpringApplication which is the primary Spring component.
    // The 'args' array is also passed through to expose any command-line arguments.
    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }
}
