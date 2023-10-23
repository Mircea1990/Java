package com.springcore.scope.singletone;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class SingletonLookupBean {
    @Lookup
    public PrototypeBean getPrototypeBean() {
        return null;
    }
}
