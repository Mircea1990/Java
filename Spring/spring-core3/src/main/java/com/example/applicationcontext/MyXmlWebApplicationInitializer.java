package com.example.applicationcontext;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.lang.NonNull;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

// This class implements the WebApplicationInitializer interface which is used to configure the
// ServletContext programmatically.
public class MyXmlWebApplicationInitializer implements WebApplicationInitializer {
    // This method will be called when the application starts up. It takes a ServletContext as an
    // argument.
    public void onStartup(@NonNull ServletContext container) {
        // Creating a new XmlWebApplicationContext. It's a Spring container that reads
        // configuration from an XML file.
        XmlWebApplicationContext context = new XmlWebApplicationContext();
        // Setting the location of the XML configuration file.
        context.setConfigLocation("/WEB-INF/spring/applicationContext.xml");
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

