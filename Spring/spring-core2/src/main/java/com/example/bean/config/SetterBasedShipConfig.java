package com.example.bean.config;

import com.example.bean.injection.Helm;
import com.example.bean.injection.Ship;
import org.springframework.context.annotation.Bean;

public class SetterBasedShipConfig {
    // This method defines a bean named "ship" and returns an instance of Ship
    @Bean public Ship ship() {
        return new Ship();
    }

    // This method defines a bean named "helm" and returns an instance of Helm
    @Bean public Helm helm() {
        return new Helm();
    }
}
