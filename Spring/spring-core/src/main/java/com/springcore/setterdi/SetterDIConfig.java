package com.springcore.setterdi;

import com.springcore.setterdi.domain.Engine;
import com.springcore.setterdi.domain.Trailer;
import com.springcore.setterdi.domain.Transmission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springcore.setterdi")
public class SetterDIConfig {
    @Bean
    public Engine engine() {
        Engine engine = new Engine();
        engine.setType("v8");
        engine.setVolume(2);
        return engine;
    }

    @Bean
    public Transmission transmission() {
        Transmission transmission = new Transmission();
        transmission.setType("CVT");
        return transmission;
    }

    @Bean
    public Trailer trailer() {
        Trailer trailer = new Trailer();
        return trailer;
    }
}