package com.example.applicationcontext;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

// This annotation indicates that this class declares one or more @Bean methods and may be
// processed by the Spring container to generate bean definitions and service requests for those
// beans at runtime.
@Configuration public class AccountConfig {
    // This annotation indicates that this method produces a bean to be managed by the Spring
    // container.
    // Here, it's creating an instance of AccountService with accountRepository() as a dependency.
    @Bean public AccountService accountService() {
        return new AccountService(accountRepository());
    }

    // This method is creating an instance of AccountRepository to be managed by the Spring
    // container.
    @Bean public AccountRepository accountRepository() {
        return new AccountRepository();
    }

    // This method is creating an instance of MessageSource to be managed by the Spring container.
    // MessageSource is an interface used in the Spring Framework to resolve messages, supporting
    // internationalization.
    // Here, it's using ResourceBundleMessageSource which is a concrete implementation that
    // resolves messages from resource bundles for different locales.
    @Bean public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("config/messages");
        return messageSource;
    }
}

