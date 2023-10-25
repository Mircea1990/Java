package com.example.spring43.scopeannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// @Configuration is a Spring annotation that indicates the class can be used by the Spring IoC
// container as a source of bean definitions.
// @ComponentScan is another Spring annotation that tells Spring to scan and bootstrap other
// components defined in the current package or below.
// @EnableWebMvc is a Spring annotation that enables default Spring MVC configuration and
// provides the functionality equivalent to mvc:annotation-driven/ element in XML.
@Configuration @ComponentScan @EnableWebMvc

public class ScopeAnnotationsConfiguration {

    // @Bean is a Spring annotation that indicates that a method produces a bean to be managed by
    // the Spring container.
    // Here, it's creating a ViewResolver bean.
    @Bean public ViewResolver viewResolver() {
        // InternalResourceViewResolver is one of the implementation classes of the ViewResolver
        // interface.
        // It is used to resolve views based on the pre-defined URL structure.
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        // setPrefix sets the prefix that gets prepended to view names when building a URL.
        viewResolver.setPrefix("/WEB-INF/jsp/view/");

        // setSuffix sets the suffix that gets appended to view names when building a URL.
        viewResolver.setSuffix(".jsp");

        // The method returns the configured InternalResourceViewResolver bean.
        return viewResolver;
    }
}

