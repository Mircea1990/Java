package com.example.bean.injection;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// This class represents a Ship and is a Spring component
@Component @Getter public class Ship {
    // This field is autowired with the Helm bean
    @Autowired private Helm helm;

    // This constructor creates a Ship instance with a default Helm
    public Ship() {
        helm = new Helm();
    }

    // This constructor creates a Ship instance with a provided Helm
    public Ship(Helm helm) {
        this.helm = helm;
    }

    public Helm getHelm() {
        return helm;
    }

    // This method is a setter for the helm field and is autowired
    @Autowired public void setHelm(Helm helm) {
        // Set the helm field with the provided Helm bean
        this.helm = helm;
    }
}
