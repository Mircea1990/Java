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

@Configuration
@ComponentScan("com.springcore.scope")
public class AppConfig2 {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }

    @Bean
    public SingletonBean singletonBean() {
        return new SingletonBean();
    }

    @Bean
    public SingletonProviderBean singletonProviderBean() {
        return new SingletonProviderBean();
    }

    @Bean
    public SingletonAppContextBean singletonAppContextBean() {
        return new SingletonAppContextBean();
    }

    @Bean
    public SingletonObjectFactoryBean singletonObjectFactoryBean() {
        return new SingletonObjectFactoryBean();
    }

    @Bean
    public Provider<PrototypeBean> prototypeBeanProvider() {
        return this::prototypeBean;
    }

    @Bean
    public Function<String, PrototypeBean> prototypeBeanFactory() {
        return name -> prototypeBean();
    }
}
