package jakartaee.examples.jaxrs.getclient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the GET Client example.
 */
@Path("getClient") public class GetClientResource {

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
