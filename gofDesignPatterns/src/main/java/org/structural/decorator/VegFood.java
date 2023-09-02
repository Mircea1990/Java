package org.structural.decorator;

//class that will implement the Food interface and override it's all methods.
public class VegFood implements Food {

    public String prepareFood() {
        return "Veg Food";
    }

    public double foodPrice() {
        return 50.0;
    }
}
