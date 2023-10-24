package com.example.spring.patterns.factory;

import lombok.Getter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// The @Getter annotation is a Lombok annotation to auto-generate the getter methods for your
// fields.
@Getter
// The @Component annotation indicates that an annotated class is a "component".
// Such classes are considered as candidates for auto-detection when using annotation-based
// configuration and classpath scanning.
@Component
// The @Scope annotation defines the scope of the beans.
// ConfigurableBeanFactory.SCOPE_PROTOTYPE ensures that a new instance will be created every time
// a request for that specific bean is made.
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) public class Bar {
    // This is a private final field 'name' for the class 'Bar'.
    private final String name;

    // This is the constructor of the class 'Bar' which takes a String 'name' as parameter.
    public Bar(String name) {
        this.name = name;
    }
}

