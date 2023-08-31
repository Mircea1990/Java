package org.mockingAbstractClasses;

public abstract class Abstract_Class {

    public abstract int myAbstractMethod();

    public String sayMock() {
        return getName() + "13";
    }

    private String getName() {
        return "Jyotika";
    }
}
