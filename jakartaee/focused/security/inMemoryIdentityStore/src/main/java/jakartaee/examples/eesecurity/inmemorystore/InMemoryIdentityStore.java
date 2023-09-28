package jakartaee.examples.eesecurity.inmemorystore;

import static java.util.Arrays.asList;

import java.util.HashSet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;

import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

import jakarta.security.enterprise.identitystore.IdentityStore;

/**
 * The in-memory identity store.
 */
@ApplicationScoped public class InMemoryIdentityStore implements IdentityStore {

    /**
     * Validate the username / password credential.
     *
     * @param usernamePasswordCredential the username / password credential.
     * @return the result.
     */
    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        if (usernamePasswordCredential.compareTo("test", "test")) {
            return new CredentialValidationResult("test", new HashSet<>(asList("user")));
        }
        return INVALID_RESULT;
    }
}
