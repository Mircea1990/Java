package org.abstractTest;

public abstract class AbstractClass {

    public String sayMock() {
        return "Hii.. " + getName() + symbol();
    }

    private String symbol() {
        return "!!";
    }

    protected abstract String getName();
}
