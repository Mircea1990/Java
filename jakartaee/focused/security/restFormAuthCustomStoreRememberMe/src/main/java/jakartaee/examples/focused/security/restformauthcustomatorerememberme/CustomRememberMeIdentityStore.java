package jakartaee.examples.focused.security.restformauthcustomatorerememberme;


import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.CallerPrincipal;
import jakarta.security.enterprise.credential.RememberMeCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.RememberMeIdentityStore;

import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

/**
 * A custom remember-me identity store that will be picked up automatically by Jakarta Security.
 *
 * <p>
 * Jakarta Security picks up any enabled CDI bean that implements
 * <code>RememberMeIdentityStore</code>.
 */
@ApplicationScoped public class CustomRememberMeIdentityStore implements RememberMeIdentityStore {

    private final Map<String, CredentialValidationResult> tokenToIdentityMap =
            new ConcurrentHashMap<>();

    @Override public CredentialValidationResult validate(RememberMeCredential credential) {
        if (tokenToIdentityMap.containsKey(credential.getToken())) {
            return tokenToIdentityMap.get(credential.getToken());
        }

        return INVALID_RESULT;
    }

    @Override
    public String generateLoginToken(CallerPrincipal callerPrincipal, Set<String> groups) {
        var token = UUID.randomUUID().toString();

        tokenToIdentityMap.put(token, new CredentialValidationResult(callerPrincipal, groups));

        return token;
    }

    @Override public void removeLoginToken(String token) {
        tokenToIdentityMap.remove(token);
    }

}
