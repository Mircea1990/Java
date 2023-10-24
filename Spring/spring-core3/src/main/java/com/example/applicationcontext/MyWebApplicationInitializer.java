package com.example.applicationcontext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// This class implements the WebApplicationInitializer interface which is used to configure the
// ServletContext programmatically.
public class MyWebApplicationInitializer implements WebApplicationInitializer {
    // This method will be called when the application starts up. It takes a ServletContext as an
    // argument.
    public void onStartup(@NonNull ServletContext container) {
        // Creating a new AnnotationConfigWebApplicationContext. It's a Spring container that
        // looks for configuration classes annotated with @Configuration and registers their
        // @Bean methods.
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // Registering the AccountConfig configuration class with the context.
        context.register(AccountConfig.class);
        // Setting the ServletContext for this web application.
        context.setServletContext(container);
        // Adding a new servlet to this context. The servlet is an instance of DispatcherServlet
        // which is the front controller in Spring MVC that dispatches requests to handlers.
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher",
                                                                   new DispatcherServlet(context));
        // This servlet will be loaded when the application starts up (load-on-startup order is 1).
        servlet.setLoadOnStartup(1);
        // The servlet is mapped to handle all requests ("/").
        servlet.addMapping("/");
    }
}

