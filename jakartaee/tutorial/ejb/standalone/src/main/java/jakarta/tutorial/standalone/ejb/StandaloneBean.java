package jakarta.tutorial.standalone.ejb;

import jakarta.ejb.Stateless;

@Stateless public class StandaloneBean {

    private static final String message = "Greetings!";

    public String returnMessage() {
        return message;
    }

}
