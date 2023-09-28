package jakarta.tutorial.helloservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService public class Hello {

    private final String message = "Hello, ";

    public Hello() {
    }

    @WebMethod public String sayHello(String name) {
        return message + name + ".";
    }
}
