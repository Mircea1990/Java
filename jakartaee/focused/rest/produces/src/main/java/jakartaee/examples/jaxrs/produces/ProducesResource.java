package jakartaee.examples.jaxrs.produces;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the @Produces example.
 */
@Path("produces") public class ProducesResource {

    /**
     * Produces method.
     *
     * @return 'And we are returning an array of strings in JSON format'
     */
    @GET @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.APPLICATION_JSON)
    public String[] produces() {
        return new String[]{"And", "we", "are", "returning", "an", "array", "of", "strings", "in",
                "JSON", "format"};
    }
}
