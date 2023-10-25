package com.example.beanpostprocessor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This is a configuration class named PostProcessorConfiguration.
// The @Configuration annotation indicates that this class declares one or more @Bean methods and
// may be processed by the Spring container to generate bean definitions and service requests for
// those beans at runtime.
@Configuration public class PostProcessorConfiguration {
    // This is a method named eventBus.
    // The @Bean annotation tells Spring that this method will return an object that should be
    // registered as a bean in the Spring application context.
    // The method returns an instance of GlobalEventBus.
    @Bean public GlobalEventBus eventBus() {
        return GlobalEventBus.getInstance();
    }

    // This is a method named eventBusBeanPostProcessor.
    // The method returns a new instance of GuavaEventBusBeanPostProcessor.
    @Bean public GuavaEventBusBeanPostProcessor eventBusBeanPostProcessor() {
        return new GuavaEventBusBeanPostProcessor();
    }

    // This is a method named stockTradePublisher.
    // The method returns a new instance of StockTradePublisher.
    @Bean public StockTradePublisher stockTradePublisher() {
        return new StockTradePublisher();
    }
}

