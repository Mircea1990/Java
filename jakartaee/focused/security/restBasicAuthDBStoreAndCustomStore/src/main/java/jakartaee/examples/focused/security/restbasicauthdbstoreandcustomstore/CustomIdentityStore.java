package jakartaee.examples.focused.security.restbasicauthdbstoreandcustomstore;

import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

/**
 * A custom identity store that will be picked up automatically by Jakarta Security.
 *
 * <p>
 * Jakarta Security picks up any enabled CDI bean that implements <code>IdentityStore</code>.
 */
@ApplicationScoped public class CustomIdentityStore implements IdentityStore {

    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        if (usernamePasswordCredential.compareTo("pete", "secret2")) {
            return new CredentialValidationResult("pete", Set.of("user", "caller"));
        }

        return INVALID_RESULT;
    }

}
