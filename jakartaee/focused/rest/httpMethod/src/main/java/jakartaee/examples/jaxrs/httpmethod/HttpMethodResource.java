package jakartaee.examples.jaxrs.httpmethod;

import jakarta.ws.rs.Path;

/**
 * The JAX-RS resource for the @HttpMethod example.
 */
@Path("httpmethod") public class HttpMethodResource {

    /**
     * HttpMethod method.
     *
     * @return "And we accepted a MYWAY call"
     */
    @MYWAY public String httpMethod() {
        return "And we accepted a MYWAY call";
    }
}
