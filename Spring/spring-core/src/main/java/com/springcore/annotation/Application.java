package com.springcore.annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

// This annotation is used to mark a class as a Spring Component. It means that Spring framework
// will autodetect this class for dependency injection when annotation-based configuration and
// classpath scanning is used.
@Component("applicationContextApplication")
// @SpringBootApplication is a convenience annotation that adds all of the following:
// @Configuration: Tags the class as a source of bean definitions for the application context.
// @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
// other beans, and various property settings.
// @ComponentScan: Tells Spring to look for other components, configurations, and services in the
// 'com/example' package, letting it find the controllers.
@SpringBootApplication public class Application {
    public static void main(String[] args) {
        // The SpringApplication.run() method returns a ConfigurableApplicationContext which we
        // can use to get beans from our application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        // Get a bean of type MyBean from the application context
        MyBean myBean = context.getBean(MyBean.class);
        // Get a bean of type TestBean from the application context
        TestBean testBean = context.getBean(TestBean.class);
    }
}


