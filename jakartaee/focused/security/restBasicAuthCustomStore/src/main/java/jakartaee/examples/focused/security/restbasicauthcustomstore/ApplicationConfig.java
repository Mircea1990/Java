package jakartaee.examples.focused.security.restbasicauthcustomstore;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped @BasicAuthenticationMechanismDefinition(realmName = "basicAuth")
@DeclareRoles({"user", "caller"}) @ApplicationPath("/rest") public class ApplicationConfig
        extends Application {

}
