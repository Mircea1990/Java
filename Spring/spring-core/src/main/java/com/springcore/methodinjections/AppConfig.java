package com.springcore.methodinjections;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation is used to indicate that the class can be used by the Spring IoC
// container
// as a source of bean definitions. The @Bean annotation tells Spring that a method annotated
// with @Bean will
// return an object that should be registered as a bean in the Spring application context.
@Configuration
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the
// packages to scan for
// annotated components. @ComponentScan without arguments tells Spring to scan the current
// package and all of its sub-packages.
@ComponentScan(basePackages = "com.springcore.methodinjections")
// This is the AppConfig class that will be used by Spring. It's currently empty but you can
// define methods
// annotated with @Bean to produce beans that will be managed by Spring.
public class AppConfig {}

