package jakartaee.examples.focused.security.restopenidconnectauth;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@OpenIdAuthenticationMechanismDefinition(
        // The values set here correspond to the Mitre server and its default account
        // that's installed via pom.xml
        providerURI = "https://localhost:8443/openid-connect-server-webapp", clientId = "client",
        clientSecret = "secret", redirectToOriginalResource = true) @ApplicationScoped
@ApplicationPath("/rest") public class ApplicationConfig extends Application {

}
