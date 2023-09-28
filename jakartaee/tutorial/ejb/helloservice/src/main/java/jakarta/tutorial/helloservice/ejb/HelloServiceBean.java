package jakarta.tutorial.helloservice.ejb;

import jakarta.ejb.Stateless;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * HelloServiceBean is a web service endpoint implemented as a stateless session bean.
 */

@Stateless @WebService public class HelloServiceBean {
    private final String message = "Hello, ";

    public HelloServiceBean() {
    }

    @WebMethod public String sayHello(String name) {
        return message + name + ".";
    }
}
