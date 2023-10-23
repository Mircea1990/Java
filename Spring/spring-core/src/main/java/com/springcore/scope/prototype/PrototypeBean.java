package com.springcore.scope.prototype;

import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class PrototypeBean {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private String name;

    public PrototypeBean() {
        logger.info("Prototype instance created");
    }

    public PrototypeBean(String name) {
        this.name = name;
        logger.info("Prototype instance " + name + " created");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
