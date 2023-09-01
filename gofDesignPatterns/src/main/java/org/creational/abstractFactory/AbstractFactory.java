package org.creational.abstractFactory;

//getting the factories for Bank and Loan Objects
abstract class AbstractFactory {

    public abstract Bank getBank(String bank);

    public abstract Loan getLoan(String loan);
}
