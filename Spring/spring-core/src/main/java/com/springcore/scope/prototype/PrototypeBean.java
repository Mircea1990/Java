package com.springcore.scope.prototype;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class PrototypeBean {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    @Getter private String name;

    public PrototypeBean() {
        logger.info("Prototype instance created");
    }

    public PrototypeBean(String name) {
        this.name = name;
        logger.info("Prototype instance " + name + " created");
    }

    public void setName(String name) {
        this.name = name;
    }

}
