package com.springcore.scope.singletone;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

// The @Component annotation marks this class as a component class for Spring to manage.
@Component public class SingletonLookupBean {
    // The @Lookup annotation is used on a method to get a new instance of a PrototypeBean each
    // time it's called.
    @Lookup public PrototypeBean getPrototypeBean() {
        // This method is overridden by the Spring container at runtime to return a new instance
        // of PrototypeBean.
        return null;
    }
}

