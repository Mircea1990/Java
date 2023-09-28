package jakartaee.examples.jaxrs.consumes;

import jakarta.json.JsonObject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @Consumes example.
 */
@Path("consumes") public class ConsumesResource {

    /**
     * Consumes method.
     *
     * @param body the body we sent over (in application/json).
     * @return the body (in text/plain)
     */
    @PUT @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.TEXT_PLAIN)
    public String consumes(JsonObject body) {
        return body.getString("string");
    }
}
