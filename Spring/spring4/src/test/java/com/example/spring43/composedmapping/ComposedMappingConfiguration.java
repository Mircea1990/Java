package com.example.spring43.composedmapping;

import java.util.Collections;

import org.easymock.EasyMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.beans.factory.InjectionPoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;

import static org.easymock.EasyMock.replay;

// The @Configuration annotation is used to indicate that the class can be used by the Spring IoC
// container as a source of bean definitions.
// The @ComponentScan annotation is used with the @Configuration annotation to tell Spring the
// packages to scan for annotated components.
// @EnableWebMvc is equivalent to mvc:annotation-driven in XML. It enables support for
// @Controller-annotated classes that use @RequestMapping to map incoming requests to a certain
// method.
@Configuration @ComponentScan @EnableWebMvc public class ComposedMappingConfiguration {

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

    // This method creates a mock AppointmentService using EasyMock and sets its behavior to
    // return an empty map when getAppointmentsForToday() is called.
    // The replay() method makes the mock object ready for use.
    @Bean public AppointmentService appointmentBook() {
        AppointmentService book = EasyMock.mock(AppointmentService.class);
        EasyMock.expect(book.getAppointmentsForToday()).andReturn(Collections.emptyMap());
        replay(book);
        return book;
    }

    // This method creates a Logger instance for the class where this bean is injected.
    // The @Scope("prototype") annotation indicates that a new instance will be created every
    // time this bean is requested.
    @Bean @Scope("prototype") public Logger logger(InjectionPoint injectionPoint) {
        return LogManager.getLogger(injectionPoint.getField().getDeclaringClass());
    }
}

