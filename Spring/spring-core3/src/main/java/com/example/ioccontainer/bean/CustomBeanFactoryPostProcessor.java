package com.example.ioccontainer.bean;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.lang.NonNull;

// The CustomBeanFactoryPostProcessor class implements the BeanFactoryPostProcessor interface
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    // A private static boolean variable to check if the BeanFactoryPostProcessor is registered
    private static boolean isBeanFactoryPostProcessorRegistered = false;

    // Method to check if the BeanFactoryPostProcessor is registered
    public static boolean isBeanFactoryPostProcessorRegistered() {
        // Returns the status of the BeanFactoryPostProcessor registration
        return isBeanFactoryPostProcessorRegistered;
    }

    // Method to set the status of the BeanFactoryPostProcessor registration
    public static void setBeanFactoryPostProcessorRegistered(boolean isBeanFactoryPostProcessorRegistered) {
        // Sets the status of the BeanFactoryPostProcessor registration
        CustomBeanFactoryPostProcessor.isBeanFactoryPostProcessorRegistered =
                isBeanFactoryPostProcessorRegistered;
    }

    // Method to post process the bean factory
    @Override public void postProcessBeanFactory(
            @NonNull ConfigurableListableBeanFactory beanFactory) {
        // Sets the status of the BeanFactoryPostProcessor registration to true
        setBeanFactoryPostProcessorRegistered(true);
    }
}

