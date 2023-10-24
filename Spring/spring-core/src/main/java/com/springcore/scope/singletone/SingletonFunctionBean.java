package com.springcore.scope.singletone;

import java.util.function.Function;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The @Component annotation marks this class as a component class for Spring to manage.
@Component
public class SingletonFunctionBean {
    // The @Autowired annotation tells Spring to inject a Function that takes a String and returns a PrototypeBean.
    @Autowired
    private Function<String, PrototypeBean> beanFactory;

    // Method to get an instance of PrototypeBean using the beanFactory. The name parameter is used by the factory to create the instance.
    public PrototypeBean getPrototypeInstance(String name) {
        return beanFactory.apply(name);
    }
}

