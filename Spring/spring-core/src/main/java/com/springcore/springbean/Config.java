package com.springcore.springbean;

import com.springcore.springbean.domain.Address;
import com.springcore.springbean.domain.Company;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation is used to indicate that a class declares one or more @Bean
// methods and may be processed by the Spring container to generate bean definitions and service
// requests for those beans at runtime
@Configuration
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the
// packages to scan for annotated components. In this case, it's scanning the package where the
// Company class is located.
@ComponentScan(basePackageClasses = Company.class) public class Config {
    // The main method which will be executed when the application starts
    public static void main(String[] args) {
        // Creating a new Spring ApplicationContext by providing configuration instructions
        // defined in the Config class
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // Getting the bean of type Company from the ApplicationContext
        Company company = context.getBean(Company.class);
        // Printing the company object to the console
        System.out.println(company);
    }

    // The @Bean annotation tells Spring that this method will return an object that should be
    // registered as a bean in the Spring application context
    @Bean public Address getAddress() {
        // Creating a new Address object with "High Street" as street and 1000 as number
        return new Address("High Street", 1000);
    }
}

