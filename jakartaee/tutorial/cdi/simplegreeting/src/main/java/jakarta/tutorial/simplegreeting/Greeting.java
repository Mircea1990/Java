package jakarta.tutorial.simplegreeting;

import jakarta.enterprise.context.Dependent;

@Dependent public class Greeting {
    public String greet(String name) {
        return "Hello, " + name + ".";
    }
}
