package jakartaee.examples.focused.security.restformauthcustomatorerememberme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.build.compatible.spi.BuildCompatibleExtension;
import jakarta.enterprise.inject.build.compatible.spi.ClassConfig;
import jakarta.enterprise.inject.build.compatible.spi.Enhancement;
import jakarta.security.enterprise.authentication.mechanism.http.FormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;
import jakarta.security.enterprise.authentication.mechanism.http.RememberMe;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped @FormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(loginPage = "/login.html",
                                           errorPage = "/login-error.html"))
@ApplicationPath("/rest") public class ApplicationConfig extends Application
        implements BuildCompatibleExtension {

    @Enhancement(types = HttpAuthenticationMechanism.class, withSubtypes = true)
    public void addRememberMe(ClassConfig httpAuthenticationMechanism) {
        httpAuthenticationMechanism.addAnnotation(RememberMe.Literal.INSTANCE);
    }

}
