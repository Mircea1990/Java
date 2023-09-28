package jakartaee.examples.jaxrs.helloworld;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS HelloWorld example.
 */
@Path("helloWorld") public class HelloWorldResource {

    /**
     * Hello World method.
     *
     * @return "Hello World"
     */
    @GET @Produces(MediaType.TEXT_PLAIN) public String helloWorld() {
        return "Hello World";
    }
}
