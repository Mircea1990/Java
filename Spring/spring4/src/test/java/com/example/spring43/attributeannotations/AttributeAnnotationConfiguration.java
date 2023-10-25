package com.example.spring43.attributeannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// The @Configuration annotation is used to indicate that the class can be used by the Spring IoC
// container as a source of bean definitions.
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the
// packages to scan for annotated components.
// @EnableWebMvc is equivalent to mvc:annotation-driven in XML. It enables support for
// @Controller-annotated classes that use @RequestMapping to map incoming requests to a certain
// method.
@Configuration @ComponentScan @EnableWebMvc public class AttributeAnnotationConfiguration
        extends WebMvcConfigurerAdapter {

    // The @Bean annotation tells Spring that this method will return an object that should be
    // registered as a bean in the Spring application context.
    // The ViewResolver implementation for JSP views is InternalResourceViewResolver. It supports
    // internal resources, typically JSPs.
    // The prefix set here is prepended to view names for building a URL. The suffix set here is
    // appended to view names for building a URL.
    @Bean public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    // This method is used for adding interceptor classes, it gets called back at runtime so we
    // can add our custom interceptors.
    // Here we are adding an instance of ParamInterceptor to the registry of interceptors.
    @Override public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ParamInterceptor());
    }
}

