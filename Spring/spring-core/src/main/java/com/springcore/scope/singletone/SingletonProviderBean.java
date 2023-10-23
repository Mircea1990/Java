package com.springcore.scope.singletone;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Provider;

@Component
public class SingletonProviderBean {
    @Autowired
    private Provider<PrototypeBean> myPrototypeBeanProvider;

    public PrototypeBean getPrototypeInstance() {
        return myPrototypeBeanProvider.get();
    }
}
