package org.structural.bridge;

// this is the Question interface.
public interface Question {

    void nextQuestion();

    void previousQuestion();

    void newQuestion(String q);

    void deleteQuestion(String q);

    void displayQuestion();

    void displayAllQuestions();
}
