package com.example.spring.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Set;

public class MyWebApplicationInitializer implements WebApplicationInitializer {
    /**
     * Register and configure all Servlet container components necessary to power the web
     * application.
     */
    @Override public void onStartup(final ServletContext sc) throws ServletException {
        // Print a message to the console when the application starts up
        System.out.println("MyWebApplicationInitializer.onStartup()");
        // Create the 'root' Spring application context
        final AnnotationConfigWebApplicationContext root =
                new AnnotationConfigWebApplicationContext();
        // Scan the specified package for Spring configuration classes
        root.scan("com.example.spring.config");
        // Add a listener to the ServletContext that will load the 'root' Spring application context
        sc.addListener(new ContextLoaderListener(root));
        // Create a DispatcherServlet that will handle requests into the Spring application context
        DispatcherServlet dv = new DispatcherServlet(root);
        // Register and map the DispatcherServlet to the ServletContext
        final ServletRegistration.Dynamic appServlet = sc.addServlet("mvc", dv);
        // Load the servlet when the application starts up
        appServlet.setLoadOnStartup(1);
        // Map the servlet to respond to "/"
        final Set<String> mappingConflicts = appServlet.addMapping("/");
        // If there are any conflicts with existing mappings, throw an exception
        if (!mappingConflicts.isEmpty()) {
            throw new IllegalStateException("'appServlet' could not be mapped to '/' due " +
                                            "to an existing mapping. This is a known issue under " +
                                            "Tomcat versions " +
                                            "<= 7.0.14; see https://issues.apache" +
                                            ".org/bugzilla/show_bug.cgi?id=51278");
        }
    }
}

