package org.behavioral.template;

// extend Game abstract class for giving the definition to its method
public class Chess extends Game {

    @Override
    void initialize() {
        System.out.println("Chess Game Initialized! Start playing.");
    }

    @Override
    void start() {
        System.out.println("Game Started. Welcome to in the chess game!");
    }

    @Override
    void end() {
        System.out.println("Game Finished!");
    }
}
