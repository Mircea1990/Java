package com.springcore.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.lang.NonNull;

public class MyBeanName implements BeanNameAware {
    @Override
    public void setBeanName(@NonNull String beanName) {
        System.out.println(beanName);
    }

    public void sayHello() {
        System.out.println("Hello from MyBeanName!");
    }
}
