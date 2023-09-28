package jakartaee.examples.jaxrs.delete;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @DELETE example.
 */
@Path("delete") public class DeleteResource {

    /**
     * Delete method.
     *
     * @return "And there is nothing left!T"
     */
    @DELETE @Consumes(MediaType.TEXT_PLAIN) @Produces(MediaType.TEXT_PLAIN) public String delete() {
        return "And there is nothing left!";
    }
}
