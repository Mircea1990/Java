package com.springcore.scope.singletone;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// The @Component annotation marks this class as a component class for Spring to manage.
@Component
public class SingletonObjectFactoryBean {
    // The @Autowired annotation tells Spring to inject an ObjectFactory that creates instances of PrototypeBean.
    @Autowired
    private ObjectFactory<PrototypeBean> prototypeBeanObjectFactory;

    // Method to get an instance of PrototypeBean using the object factory.
    public PrototypeBean getPrototypeInstance() {
        return prototypeBeanObjectFactory.getObject();
    }
}

