package org.structural.decorator;

//concrete class that will extend the FoodDecorator class and override it's all methods.
public class NonVegFood extends FoodDecorator {

    public NonVegFood(Food newFood) {
        super(newFood);
    }

    public String prepareFood() {
        return super.prepareFood() + " With Roasted Chicken and Chicken Curry  ";
    }

    public double foodPrice() {
        return super.foodPrice() + 150.0;
    }
}
