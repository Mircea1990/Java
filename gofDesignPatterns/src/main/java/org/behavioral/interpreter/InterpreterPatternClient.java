package org.behavioral.interpreter;

public class InterpreterPatternClient {

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";

        InfixToPostfixPattern ip = new InfixToPostfixPattern();

        String postfix = ip.conversion(infix);
        System.out.println("Infix:   " + infix);
        System.out.println("Postfix: " + postfix);
    }
}
