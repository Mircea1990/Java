package jakartaee.examples.jaxrs.get;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @GET example.
 */
@Path("get") public class GetResource {

    /**
     * Get method.
     *
     * @return "And we used @GET"
     */
    @GET @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "And we used @GET";
    }
}
