package com.springcore.aware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation indicates that this class declares one or more @Bean methods and may be processed by the Spring container to generate bean definitions and service requests for those beans at runtime.
@Configuration
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the packages to scan for annotated components.
// Here it is scanning the "com.springcore.aware" package.
@ComponentScan("com.springcore.aware")
public class AwareConfig {
    // The @Bean annotation tells Spring that this method will return an object that should be registered as a bean in the Spring application context.
    // The name of the bean will be "myCustomBeanName".
    @Bean(name = "myCustomBeanName")
    public MyBeanName getMyBeanName() {
        // Creating a new instance of MyBeanName
        return new MyBeanName();
    }

    // The @Bean annotation tells Spring that this method will return an object that should be registered as a bean in the Spring application context.
    // The name of the bean will be "myBeanFactory".
    @Bean
    public MyBeanFactory getMyBeanFactory() {
        // Creating a new instance of MyBeanFactory
        return new MyBeanFactory();
    }
}

