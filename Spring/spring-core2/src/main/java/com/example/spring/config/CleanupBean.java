package com.example.spring.config;

import java.util.concurrent.ExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// This annotation indicates that the class is a component.
public final class CleanupBean implements
        DisposableBean {  // This class implements the DisposableBean interface for callback on destruction of a bean.
    private final Logger logger = LoggerFactory.getLogger(getClass());  // Logger instance for this class.
    @Autowired
    // This annotation is used to autowire bean on the setter method, constructor, a property or methods with arbitrary names and/or multiple arguments.
    private ExecutorService setupExecutor;  // Autowired ExecutorService instance.

    public CleanupBean() {  // Constructor of this class.
        super();  // Calls the constructor of the superclass.
    }
    //

    @Override
    // This annotation is used to indicate that a method declaration is intended to override a method declaration in a supertype.
    public void destroy() {  // This method is declared in the DisposableBean interface and is called on the destruction of a bean.
        logger.info("Starting shutdown process - cleanup");  // Logs info message.
        setupExecutor.shutdownNow();  // Shuts down the ExecutorService.
        logger.info("Finishing shutdown process - cleanup");  // Logs info message.
    }

}
