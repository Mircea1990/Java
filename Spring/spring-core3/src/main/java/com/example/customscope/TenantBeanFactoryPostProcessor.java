package com.example.customscope;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

// This class implements the BeanFactoryPostProcessor interface, which allows for custom
// modification of an application context's bean definitions.
public class TenantBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    // This method overrides the postProcessBeanFactory method from the BeanFactoryPostProcessor
    // interface.
    // It is called by the Spring container upon initialization of the bean factory.
    @Override public void postProcessBeanFactory(ConfigurableListableBeanFactory factory)
            throws BeansException {
        // Here, a new custom scope "tenant" is registered in the bean factory using an instance
        // of TenantScope.
        // This allows beans to be scoped per tenant in a multi-tenant application.
        factory.registerScope("tenant", new TenantScope());
    }
}

