package jakarta.tutorial.custom_identity_store;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;

@BasicAuthenticationMechanismDefinition(realmName = "file")

@ApplicationScoped @Named public class ApplicationConfig {

}
