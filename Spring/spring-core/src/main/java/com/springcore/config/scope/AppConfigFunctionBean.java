package com.springcore.config.scope;

import com.springcore.scope.prototype.PrototypeBean;
import com.springcore.scope.singletone.SingletonFunctionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class AppConfigFunctionBean {
    @Autowired
    private ApplicationContext context;

    @Bean
    public Function<String, PrototypeBean> beanFactory() {
        return this::prototypeBeanWithParam;
    }

    public PrototypeBean prototypeBeanWithParam(String name) {
        PrototypeBean prototypeBean = context.getBean(PrototypeBean.class);
        prototypeBean.setName(name);
        return prototypeBean;
    }

    @Bean
    public SingletonFunctionBean singletonFunctionBean() {
        return new SingletonFunctionBean();
    }
}

