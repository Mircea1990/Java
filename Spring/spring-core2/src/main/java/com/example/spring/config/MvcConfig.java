package com.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc  // This annotation is used to enable Spring MVC.
@Configuration
// This annotation is used to indicate that the class declares one or more @Bean methods.
public class MvcConfig implements
                       WebMvcConfigurer {  // This class implements the WebMvcConfigurer
    // interface for callback configuration of a Web MVC application.
    public MvcConfig() {  // Constructor of this class.
        super();  // Calls the constructor of the superclass.
    }
    // API

    @Override
    // This annotation is used to indicate that a method declaration is intended to override a
    // method declaration in a supertype.
    public void addViewControllers(final ViewControllerRegistry registry) {  // This method adds
        // view controllers to the registry.
        registry.addViewController(
                "/sample.html");  // Adds a view controller that maps to "/sample.html".
    }

    @Bean
    // This annotation is used to indicate that a method produces a bean to be managed by the
    // Spring container.
    public ViewResolver viewResolver() {  // This method creates a ViewResolver bean.
        final InternalResourceViewResolver bean =
                new InternalResourceViewResolver();  // Creates a new InternalResourceViewResolver.
        bean.setViewClass(JstlView.class);  // Sets the view class to JstlView.
        bean.setPrefix("/WEB-INF/view/");  // Sets the prefix for views.
        bean.setSuffix(".jsp");  // Sets the suffix for views.
        return bean;  // Returns the created InternalResourceViewResolver.
    }
}
