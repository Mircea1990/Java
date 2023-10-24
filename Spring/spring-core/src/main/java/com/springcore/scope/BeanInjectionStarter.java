package com.springcore.scope;

import com.springcore.scope.prototype.PrototypeBean;
import com.springcore.scope.singletone.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class BeanInjectionStarter {
    public static void main(String[] args) throws InterruptedException {
        // Creates a new Spring application context and provides the configuration class.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig2.class);
        // Retrieves the SingletonBean instance from the application context.
        SingletonBean firstSingleton = context.getBean(SingletonBean.class);
        // Retrieves the PrototypeBean instance associated with the first SingletonBean.
        PrototypeBean firstPrototype = firstSingleton.getPrototypeBean();
        // Retrieves another SingletonBean instance from the application context.
        SingletonBean secondSingleton = context.getBean(SingletonBean.class);
        // Retrieves the PrototypeBean instance associated with the second SingletonBean.
        PrototypeBean secondPrototype = secondSingleton.getPrototypeBean();
        // Asserts that the two PrototypeBeans retrieved are the same instance.
        // This will throw an IllegalStateException if the assertion is false.
        Assert.isTrue(firstPrototype.equals(secondPrototype), "The same instance is returned");
    }
}

