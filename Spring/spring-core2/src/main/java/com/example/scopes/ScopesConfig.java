package com.example.scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Configuration  // This annotation is used to indicate that the class declares one or more @Bean methods.
public class ScopesConfig {
    @Bean  // This annotation is used to indicate that a method produces a bean to be managed by the Spring container.
    @Scope("singleton")  // This bean is a singleton and Spring will ensure that only one instance exists.
    public Person personSingleton() {
        return new Person();
    }

    @Bean
    @Scope("prototype")  // A new instance will be created every time this bean is requested.
    public Person personPrototype() {
        return new Person();
    }

    @Bean
    @RequestScope
    // This bean is scoped at the HTTP request level. A new instance will be created for each HTTP request.
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @SessionScope
    // This bean is scoped at the HTTP session level. A new instance will be created for each HTTP session.
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @ApplicationScope
    // This bean is scoped at the application level. A new instance will be created for each ServletContext.
    public HelloMessageGenerator applicationScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope(scopeName = "websocket", proxyMode = ScopedProxyMode.TARGET_CLASS)
    // This bean is scoped at the websocket level. A new instance will be created for each websocket session.
    public HelloMessageGenerator websocketScopedBean() {
        return new HelloMessageGenerator();
    }
}
