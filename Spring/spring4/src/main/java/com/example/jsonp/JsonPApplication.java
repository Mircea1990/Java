package com.example.jsonp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

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

// The @PropertySource annotation is used to provide properties from a file in the classpath. In
// this case, it's loading properties from 'jsonp-application.properties'.
@PropertySource("classpath:jsonp-application.properties")

public class JsonPApplication extends SpringBootServletInitializer {

    // The main method uses Spring Boot’s SpringApplication.run() method to launch an application.
    public static void main(String[] args) {
        SpringApplication.run(JsonPApplication.class, args);
    }

    // This method is used when the application is a war deployment. It points to the application
    // class.
    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JsonPApplication.class);
    }

    // The CommandLineRunner interface indicates that a bean should run when it is contained
    // within a SpringApplication.
    // A Spring Boot application will call the run methods of all beans implementing this
    // interface after the application context has been loaded.
    @Bean public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Welcome to JsonP Application!");
        };
    }
}


