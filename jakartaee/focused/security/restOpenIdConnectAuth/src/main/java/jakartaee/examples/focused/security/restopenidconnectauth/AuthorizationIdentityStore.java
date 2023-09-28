package jakartaee.examples.focused.security.restopenidconnectauth;

import static jakarta.security.enterprise.identitystore.IdentityStore.ValidationType.PROVIDE_GROUPS;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStore;

/**
 * Extra identity store that assigns roles to the caller which authenticates with the Mitre OpenID
 * Connect Provider.
 */
@ApplicationScoped public class AuthorizationIdentityStore implements IdentityStore {

    private Map<String, Set<String>> groupsPerCaller = Map.of("user", Set.of("user"));

    @Override public Set<ValidationType> validationTypes() {
        return EnumSet.of(PROVIDE_GROUPS);
    }

    @Override public Set<String> getCallerGroups(CredentialValidationResult validationResult) {
        return groupsPerCaller.get(validationResult.getCallerPrincipal().getName());
    }

}
