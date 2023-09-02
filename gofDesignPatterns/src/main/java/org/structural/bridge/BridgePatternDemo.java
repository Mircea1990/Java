package org.structural.bridge;

public class BridgePatternDemo {

    public static void main(String[] args) {
        QuestionFormat questions = new QuestionFormat("Java Programming Language");

        //decouple the functional abstraction from the implementation so that the two can vary independently
        questions.q = new JavaQuestions();
        questions.delete("what is class?");
        questions.display();
        questions.newOne("What is inheritance? ");

        questions.newOne("How many types of inheritance are there in java?");
        questions.displayAll();
    }
}
