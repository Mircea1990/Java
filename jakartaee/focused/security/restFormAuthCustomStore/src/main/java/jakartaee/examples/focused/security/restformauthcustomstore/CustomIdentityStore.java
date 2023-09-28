package jakartaee.examples.focused.security.restformauthcustomstore;

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
        if (usernamePasswordCredential.compareTo("john", "secret1")) {
            return new CredentialValidationResult("john", Set.of("user", "caller"));
        }

        return INVALID_RESULT;
    }

}
