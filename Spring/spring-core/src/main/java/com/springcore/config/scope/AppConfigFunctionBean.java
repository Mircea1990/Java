package com.springcore.config.scope;

import com.springcore.scope.prototype.PrototypeBean;
import com.springcore.scope.singletone.SingletonFunctionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

// This annotation indicates that this class provides configuration for the application.
@Configuration public class AppConfigFunctionBean {
    // This annotation is used to automatically inject an instance of ApplicationContext into
    // this class.
    @Autowired private ApplicationContext context;

    // This method is annotated with @Bean, indicating that it returns an object that should be
    // registered as a bean in the Spring application context.
    // The returned function takes a String as input and returns an instance of PrototypeBean.
    @Bean public Function<String, PrototypeBean> beanFactory() {
        return this::prototypeBeanWithParam;
    }

    // This method creates a new instance of PrototypeBean with a given name.
    // It retrieves the PrototypeBean from the application context, sets its name, and then
    // returns it.
    public PrototypeBean prototypeBeanWithParam(String name) {
        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        prototypeBean.setName(name);
        return prototypeBean;
    }

    // This method is annotated with @Bean, indicating that it returns an object that should be
    // registered as a bean in the Spring application context.
    // It creates and returns a new instance of SingletonFunctionBean.
    @Bean public SingletonFunctionBean singletonFunctionBean() {
        return new SingletonFunctionBean();
    }
}


