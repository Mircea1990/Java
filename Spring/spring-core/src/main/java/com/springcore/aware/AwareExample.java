package com.springcore.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwareExample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AwareConfig.class);
        MyBeanName myBeanName = context.getBean(MyBeanName.class);
        myBeanName.sayHello();
        MyBeanFactory myBeanFactory = context.getBean(MyBeanFactory.class);
        myBeanFactory.getMyBeanName();
    }
}
