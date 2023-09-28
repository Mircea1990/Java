package jakartaee.examples.jaxrs.formparam;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @FormParam example.
 */
@Path("formParam") public class FormParamResource {

    /**
     * Form param method.
     *
     * @param formParam the form parameter.
     * @return the value of the form parameter.
     */
    @POST @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_PLAIN)
    public String formParam(@FormParam("formParam") String formParam) {
        return formParam;
    }
}
