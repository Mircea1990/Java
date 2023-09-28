package jakartaee.examples.focused.security.restBasicAuthLdapStore;

import java.io.ByteArrayInputStream;

import com.unboundid.ldap.listener.InMemoryDirectoryServer;
import com.unboundid.ldap.listener.InMemoryDirectoryServerConfig;
import com.unboundid.ldap.listener.InMemoryListenerConfig;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldif.LDIFReader;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Destroyed;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.security.enterprise.identitystore.LdapIdentityStoreDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationScoped @BasicAuthenticationMechanismDefinition(realmName = "basicAuth")
@LdapIdentityStoreDefinition(url = "ldap://localhost:40000",
                             callerBaseDn = "ou=caller,dc=jakartaee",
                             groupSearchBase = "ou=group,dc=jakartaee",
                             groupSearchFilter = "(&(member=%s)(objectclass=groupofnames))")
@ApplicationPath("/rest") public class ApplicationConfig extends Application {

    private InMemoryDirectoryServer directoryServer;

    public void onStart(@Observes @Initialized(ApplicationScoped.class) Object applicationContext) {
        try {
            InMemoryDirectoryServerConfig config = new InMemoryDirectoryServerConfig(
                    "dc=jakartaee");
            config.setListenerConfigs(
                    new InMemoryListenerConfig("myListener", null, 40000, null, null, null));

            directoryServer = new InMemoryDirectoryServer(config);

            directoryServer.importFromLDIF(true, new LDIFReader(new ByteArrayInputStream("""

                                                                                                 # Define caller.jakartaee and group.jakartaee structure

                                                                                                 dn: dc=jakartaee
                                                                                                 objectclass: top
                                                                                                 objectclass: dcObject
                                                                                                 objectclass: organization
                                                                                                 dc: jakartaee
                                                                                                 o: jakartaee

                                                                                                 dn: ou=caller,dc=jakartaee
                                                                                                 objectclass: top
                                                                                                 objectclass: organizationalUnit
                                                                                                 ou: caller

                                                                                                 dn: ou=group,dc=jakartaee
                                                                                                 objectclass: top
                                                                                                 objectclass: organizationalUnit
                                                                                                 ou: group



                                                                                                 # Add caller john:secret1 and group user with member john

                                                                                                 dn: uid=john,ou=caller,dc=jakartaee
                                                                                                 objectclass: top
                                                                                                 objectclass: uidObject
                                                                                                 objectclass: person
                                                                                                 uid: john
                                                                                                 cn: John Smith
                                                                                                 sn: John
                                                                                                 userPassword: secret1

                                                                                                 dn: cn=user,ou=group,dc=jakartaee
                                                                                                 objectclass: top
                                                                                                 objectclass: groupOfNames
                                                                                                 cn: user
                                                                                                 member: uid=john,ou=caller,dc=jakartaee

                                                                                                 """.getBytes())));

            directoryServer.startListening();
        } catch (LDAPException e) {
            throw new IllegalStateException(e);
        }
    }

    public void onDestroy(@Observes @Destroyed(ApplicationScoped.class) Object applicationContext) {
        directoryServer.shutDown(true);

    }
}
