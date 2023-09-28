package jakartaee.examples.jaxrs.pathparam;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @PathParam example.
 */
@Path("pathParam") public class PathParamResource {

    /**
     * Path param method.
     *
     * @param pathParam the path parameter.
     * @return the value of the path parameter.
     */
    @GET @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_PLAIN)
    @Path("{pathParam}") public String pathParam(@PathParam("pathParam") String pathParam) {
        return pathParam;
    }
}
