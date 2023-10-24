package com.springcore.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.lang.NonNull;

// This class implements the BeanNameAware interface which is part of the Spring Framework.
// The BeanNameAware interface provides a callback that supplies the name of the bean in the bean factory that created this bean.
public class MyBeanName implements BeanNameAware {
    // The setBeanName method is overridden from the BeanNameAware interface.
    // This method is used to set the name of the bean in the bean factory that created this bean.
    @Override
    public void setBeanName(@NonNull String beanName) {
        // Printing the name of the bean.
        System.out.println(beanName);
    }

    // This method is used to print a custom message.
    public void sayHello() {
        // Printing a custom message.
        System.out.println("Hello from MyBeanName!");
    }
}

