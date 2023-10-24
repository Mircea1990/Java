package com.example.applicationcontext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

// This class is a Spring component and provides access to the ApplicationContext
@Component public class ApplicationContextProvider implements ApplicationContextAware {
    // This field will hold the ApplicationContext instance
    @lombok.Getter private static ApplicationContext applicationContext;

    // This method is called by the Spring framework to set the ApplicationContext
    @Override public void setApplicationContext(@NonNull ApplicationContext applicationContext)
            throws BeansException {
        // Set the ApplicationContext instance to the applicationContext field
        ApplicationContextProvider.applicationContext = applicationContext;
    }
}