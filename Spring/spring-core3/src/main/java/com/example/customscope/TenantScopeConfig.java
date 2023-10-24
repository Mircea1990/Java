package com.example.customscope;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This class is marked as a configuration class. It defines methods to instantiate and configure
// the dependencies.
@Configuration public class TenantScopeConfig {
    // This method is marked with @Bean annotation which means it will be instantiated,
    // assembled, and managed by Spring IoC container.
    // It returns a BeanFactoryPostProcessor that allows for custom modification of an
    // application context's bean definitions.
    // In this case, it returns a new instance of TenantBeanFactoryPostProcessor.
    @Bean public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new TenantBeanFactoryPostProcessor();
    }
}

