package jakartaee.examples.eesecurity.servlet;

import java.io.Serializable;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.FacesConfig;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

@ApplicationScoped @BasicAuthenticationMechanismDefinition(realmName = "basicAuth")
@DatabaseIdentityStoreDefinition(dataSourceLookup = "java:comp/DefaultDataSource",
                                 callerQuery = "select password from eesecurity_servlet_user " +
                                               "where username = ?",
                                 groupsQuery = "select name from eesecurity_servlet_group where " +
                                               "username = ?",
                                 hashAlgorithm = Pbkdf2PasswordHash.class,
                                 hashAlgorithmParameters = {"Pbkdf2PasswordHash.Iterations=3072",
                                         "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA512",
                                         "Pbkdf2PasswordHash.SaltSizeBytes=64"})
@FacesConfig(version = FacesConfig.Version.JSF_2_3) @Named public class ApplicationConfig
        implements Serializable {}
