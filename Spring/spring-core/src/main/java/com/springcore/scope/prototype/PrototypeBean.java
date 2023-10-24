package com.springcore.scope.prototype;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

// The @Component annotation indicates that this class is a "component".
// Such classes are considered as candidates for auto-detection when using annotation-based configuration and classpath scanning.
@Component
public class PrototypeBean {
    // Logger instance for this class is created.
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    // @Getter is a Lombok annotation to auto-generate the getter method for this property.
    @Getter private String name;

    // Default constructor for the PrototypeBean class.
    // Logs the creation of a prototype instance.
    public PrototypeBean() {
        logger.info("Prototype instance created");
    }

    // Parameterized constructor for the PrototypeBean class.
    // Sets the 'name' property and logs the creation of a prototype instance with the given name.
    public PrototypeBean(String name) {
        this.name = name;
        logger.info("Prototype instance " + name + " created");
    }

    // Setter method for 'name' property.
    public void setName(String name) {
        this.name = name;
    }
}

