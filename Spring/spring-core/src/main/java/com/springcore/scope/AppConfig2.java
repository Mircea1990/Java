package com.springcore.scope;

import com.springcore.scope.prototype.PrototypeBean;
import com.springcore.scope.singletone.SingletonAppContextBean;
import com.springcore.scope.singletone.SingletonBean;
import com.springcore.scope.singletone.SingletonObjectFactoryBean;
import com.springcore.scope.singletone.SingletonProviderBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.inject.Provider;

@Configuration // This annotation is used to indicate that the class declares one or more @Bean methods.
@ComponentScan("com.springcore.scope")
// This annotation is used to specify the base packages to scan for annotated components.
public class AppConfig2 {
    @Bean // This annotation is used to indicate that a method produces a bean to be managed by the Spring container.
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    // This annotation is used to specify the scope of the bean. In this case, a new instance will be created every time the bean is requested.
    public PrototypeBean prototypeBean() {
        return new PrototypeBean(); // Returns a new instance of PrototypeBean.
    }

    @Bean // This annotation indicates that this method produces a bean to be managed by the Spring container.
    public SingletonBean singletonBean() {
        return new SingletonBean(); // Returns a new instance of SingletonBean.
    }

    @Bean // This annotation indicates that this method produces a bean to be managed by the Spring container.
    public SingletonProviderBean singletonProviderBean() {
        return new SingletonProviderBean(); // Returns a new instance of SingletonProviderBean.
    }

    @Bean // This annotation indicates that this method produces a bean to be managed by the Spring container.
    public SingletonAppContextBean singletonAppContextBean() {
        return new SingletonAppContextBean(); // Returns a new instance of SingletonAppContextBean.
    }

    @Bean // This annotation indicates that this method produces a bean to be managed by the Spring container.
    public SingletonObjectFactoryBean singletonObjectFactoryBean() {
        return new SingletonObjectFactoryBean(); // Returns a new instance of SingletonObjectFactoryBean.
    }

    @Bean // This annotation indicates that this method produces a bean to be managed by the Spring container.
    public Provider<PrototypeBean> prototypeBeanProvider() {
        return this::prototypeBean; // Returns a provider for PrototypeBeans. The provider's get() method will return a new instance each time because PrototypeBeans are prototype scoped.
    }

    @Bean // This annotation indicates that this method produces a bean to be managed by the Spring container.
    public Function<String, PrototypeBean> prototypeBeanFactory() {
        return name -> prototypeBean(); // Returns a function that can produce PrototypeBeans. The function takes a string (name) as input but doesn't use it, and returns a new PrototypeBean each time it's called because PrototypeBeans are prototype scoped.
    }
}
