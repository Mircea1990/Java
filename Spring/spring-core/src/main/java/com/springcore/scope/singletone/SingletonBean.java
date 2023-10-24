package com.springcore.scope.singletone;

import com.springcore.scope.prototype.PrototypeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.logging.Logger;

// The @Component annotation marks this class as a component class for Spring to manage.
@Component public class SingletonBean {
    // Logger instance to log messages.
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    // The @Autowired annotation tells Spring to inject an instance of PrototypeBean into this
    // SingletonBean.
    @Autowired private PrototypeBean prototypeBean;

    // Constructor of the SingletonBean class. Logs a message when an instance is created.
    public SingletonBean() {
        logger.info("Singleton instance created");
    }

    // Method to get the instance of PrototypeBean. Logs the current time when called.
    public PrototypeBean getPrototypeBean() {
        logger.info(String.valueOf(LocalTime.now()));
        return prototypeBean;
    }
}
