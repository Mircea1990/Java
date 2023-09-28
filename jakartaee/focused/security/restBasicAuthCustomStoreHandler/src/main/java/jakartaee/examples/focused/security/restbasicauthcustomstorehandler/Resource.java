package jakartaee.examples.focused.security.restbasicauthcustomstorehandler;

import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.security.enterprise.SecurityContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("/resource") @RequestScoped public class Resource {

    @Inject private SecurityContext securityContext;

    @GET @Produces(TEXT_PLAIN) public String getCallerAndRole() {
        return securityContext.getCallerPrincipal().getName() + " : " +
               securityContext.isCallerInRole("user") + "," + securityContext.isCallerInRole(
                "caller1") + "," + securityContext.isCallerInRole("caller2");
    }

}
