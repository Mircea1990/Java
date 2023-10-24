package com.example.bean.config;

import com.example.bean.injection.Helm;
import com.example.bean.injection.Ship;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// This class is a configuration class
@Configuration
public class ConstructorBasedShipConfig {
    // This method defines a bean named "ship" and returns an instance of Ship
    @Bean
    public Ship ship() {
        // The Ship instance is created by invoking the helm() method
        return new Ship(helm());
    }

    // This method defines a bean named "helm" and returns an instance of Helm
    @Bean
    public Helm helm() {
        return new Helm();
    }
}
