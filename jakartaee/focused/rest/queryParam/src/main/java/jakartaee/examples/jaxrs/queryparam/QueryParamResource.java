package jakartaee.examples.jaxrs.queryparam;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS @QueryParam example.
 */
@Path("queryParam") public class QueryParamResource {

    /**
     * Query param method.
     *
     * @param queryParam the query parameter.
     * @return the value of the query parameter.
     */
    @POST @Consumes(MediaType.APPLICATION_FORM_URLENCODED) @Produces(MediaType.TEXT_PLAIN)
    public String queryParam(@QueryParam("myparam") String queryParam) {
        return queryParam;
    }
}
