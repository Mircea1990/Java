package jakarta.tutorial.built_in_db_identity_store;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

// Database Definition for built-in DatabaseIdentityStore
@DatabaseIdentityStoreDefinition(callerQuery = "#{'select password from caller where name = ?'}",
                                 groupsQuery = "select group_name from caller_groups where " +
                                               "caller_name = ?",
                                 hashAlgorithm = Pbkdf2PasswordHash.class,
                                 priorityExpression = "#{100}",
                                 hashAlgorithmParameters = {"Pbkdf2PasswordHash.Iterations=3072",
                                         "${applicationConfig.dyna}"})

@BasicAuthenticationMechanismDefinition(realmName = "file")

@ApplicationScoped @Named public class ApplicationConfig {

    public String[] getDyna() {
        return new String[]{"Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
                "Pbkdf2PasswordHash.SaltSizeBytes=64"};
    }

}
