package com.example.ioccontainer.bean;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;

// The CustomBeanPostProcessor class implements the BeanPostProcessor interface
public class CustomBeanPostProcessor implements BeanPostProcessor {
    // A private static boolean variable to check if the BeanPostProcessor is registered
    private static boolean isBeanPostProcessorRegistered = false;

    // Method to check if the BeanPostProcessor is registered
    public static boolean isBeanPostProcessorRegistered() {
        // Returns the status of the BeanPostProcessor registration
        return isBeanPostProcessorRegistered;
    }

    // Method to set the status of the BeanPostProcessor registration
    public static void setBeanPostProcessorRegistered(boolean isBeanPostProcessorRegistered) {
        // Sets the status of the BeanPostProcessor registration
        CustomBeanPostProcessor.isBeanPostProcessorRegistered = isBeanPostProcessorRegistered;
    }

    // Method to post process before initialization
    @Override public Object postProcessBeforeInitialization(@NonNull Object bean,
                                                            @NonNull String beanName) {
        // Sets the status of the BeanPostProcessor registration to true
        setBeanPostProcessorRegistered(true);
        // Returns the bean
        return bean;
    }
}

