package com.springcore.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.lang.NonNull;

// This class implements the BeanFactoryAware interface which is part of the Spring Framework.
// The BeanFactoryAware interface provides a callback that supplies the owning factory to a bean
// instance.
public class MyBeanFactory implements BeanFactoryAware {
    // Declaring a private variable of type BeanFactory.
    private BeanFactory beanFactory;

    // The setBeanFactory method is overridden from the BeanFactoryAware interface.
    // This method is used to set the BeanFactory that this bean runs in.
    @Override public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        // Assigning the passed beanFactory to the private variable.
        this.beanFactory = beanFactory;
    }

    // This method is used to get a bean of type MyBeanName from the BeanFactory.
    public void getMyBeanName() {
        // Getting the bean of type MyBeanName from the BeanFactory.
        MyBeanName myBeanName = beanFactory.getBean(MyBeanName.class);
        // Printing whether the bean with name "myCustomBeanName" is a singleton or not.
        System.out.println(beanFactory.isSingleton("myCustomBeanName"));
    }
}

