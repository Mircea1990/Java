package jakartaee.examples.jaxrs.put;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @PUT example.
 */
@Path("put") public class PutResource {

    /**
     * Put method.
     *
     * @return "And we used @PUT"
     */
    @PUT @Consumes(MediaType.TEXT_PLAIN) @Produces(MediaType.TEXT_PLAIN) public String put() {
        return "And we used @PUT";
    }
}
