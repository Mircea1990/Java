package jakartaee.examples.focused.security.restformauthcustomstore;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped @FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(loginPage = "/login.html",
                                           errorPage = "/login-error.html"))
@DeclareRoles({"user", "caller"}) @ApplicationPath("/rest") public class ApplicationConfig
        extends Application {

}
