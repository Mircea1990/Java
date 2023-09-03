package org.behavioral.template;

public class TemplatePatternDemo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Class<?> c = Class.forName("org.behavioral.template.Soccer");
        Game game = (Game) c.newInstance();
        game.play();
    }
}
