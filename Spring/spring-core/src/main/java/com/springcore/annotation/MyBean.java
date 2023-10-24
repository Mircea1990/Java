package com.springcore.annotation;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// The @Component annotation is used to indicate that a class is a "component". These classes are
// considered as candidates for auto-detection when using annotation-based configuration and
// classpath scanning.
@Component public class MyBean {
    // This is the constructor of the MyBean class. It takes an instance of TestBean as a
    // parameter. The @Autowired annotation can be used to auto-wire bean on the setter method,
    // constructor, a property or methods with arbitrary names and/or multiple arguments.
    public MyBean(TestBean testBean) {
        // This message is printed when the MyBean object is created.
        System.out.println("Hello from constructor");
    }

    // The @PostConstruct annotation is used on a method that needs to be executed after
    // dependency injection is done to perform any initialization.
    @PostConstruct private void postConstruct() {
        // This message is printed after the MyBean object has been constructed and dependency
        // injection has been performed.
        System.out.println("Hello from @PostConstruct method");
    }

    // The @PreDestroy annotation is used on methods as a callback notification to signal that
    // the instance is in the process of being removed by the container.
    @PreDestroy public void preDestroy() {
        // This message is printed when the MyBean object is about to be destroyed.
        System.out.println("Bean is being destroyed");
    }
}
