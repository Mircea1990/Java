package jakartaee.examples.jaxrs.post;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @POST example.
 */
@Path("post") public class PostResource {

    /**
     * Post method.
     *
     * @return "And we used @POST"
     */
    @POST @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_PLAIN)
    public String post() {
        return "And we used @POST";
    }
}
