package com.springcore.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareExample {
    public static void main(String[] args) {
        // Creating a new AnnotationConfigApplicationContext, passing in the AwareConfig class to
        // the constructor.
        // This will bootstrap the Spring application context, registering all the beans defined
        // in AwareConfig.
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AwareConfig.class);
        // Retrieving an instance of MyBeanName from the application context.
        MyBeanName myBeanName = context.getBean(MyBeanName.class);
        // Calling the sayHello() method on the MyBeanName instance.
        myBeanName.sayHello();
        // Retrieving an instance of MyBeanFactory from the application context.
        MyBeanFactory myBeanFactory = context.getBean(MyBeanFactory.class);
        // Calling the getMyBeanName() method on the MyBeanFactory instance.
        myBeanFactory.getMyBeanName();
    }
}

