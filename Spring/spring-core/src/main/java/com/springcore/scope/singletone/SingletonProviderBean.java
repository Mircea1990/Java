package com.springcore.scope.singletone;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

// The @Component annotation marks this class as a component class for Spring to manage.
@Component public class SingletonProviderBean {
    // The @Autowired annotation tells Spring to inject a Provider that creates instances of
    // PrototypeBean.
    @Autowired private Provider<PrototypeBean> myPrototypeBeanProvider;

    // Method to get an instance of PrototypeBean using the provider.
    public PrototypeBean getPrototypeInstance() {
        return myPrototypeBeanProvider.get();
    }
}

