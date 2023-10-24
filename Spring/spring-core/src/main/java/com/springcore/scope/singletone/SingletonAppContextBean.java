package com.springcore.scope.singletone;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;

// This class is a Singleton Bean that is aware of the ApplicationContext.
// It implements the ApplicationContextAware interface to get the reference to the ApplicationContext.
public class SingletonAppContextBean implements ApplicationContextAware {
    // The ApplicationContext instance.
    private ApplicationContext applicationContext;

    // This method returns a PrototypeBean instance from the ApplicationContext.
    public PrototypeBean getPrototypeBean() {
        return applicationContext.getBean(PrototypeBean.class);
    }

    // This method is overridden from the ApplicationContextAware interface.
    // It sets the ApplicationContext instance when the bean is created by the Spring container.
    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

