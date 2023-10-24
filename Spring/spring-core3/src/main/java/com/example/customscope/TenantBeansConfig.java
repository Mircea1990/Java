package com.example.customscope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// This class is marked with the @Configuration annotation,
// which indicates that it will provide @Bean definitions to the Spring container.
@Configuration public class TenantBeansConfig {
    // This method is marked with the @Bean annotation, which indicates that a method produces a
    // bean to be managed by the Spring container.
    // The @Scope annotation indicates that the beans created by this method will have a custom
    // scope "tenant".
    // The method returns an instance of TenantBean with the name "foo".
    @Scope(scopeName = "tenant") @Bean public TenantBean foo() {
        return new TenantBean("foo");
    }

    // Similar to the foo() method, this method is also marked with the @Bean and @Scope
    // annotations.
    // It returns an instance of TenantBean with the name "bar".
    @Scope(scopeName = "tenant") @Bean public TenantBean bar() {
        return new TenantBean("bar");
    }
}

