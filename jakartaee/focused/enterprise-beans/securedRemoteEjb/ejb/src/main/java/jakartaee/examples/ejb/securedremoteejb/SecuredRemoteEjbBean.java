package java.jakartaee.examples.ejb.securedremoteejb;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Stateless;

/**
 * A secured remote stateless session bean.
 */
@Stateless(name = "securedRemoteEjb") public class SecuredRemoteEjbBean
        implements jakartaee.examples.ejb.securedremoteejb.SecuredRemoteEjb {

    /**
     * Hello world!
     *
     * @return "Hello World!"
     */
    @Override @RolesAllowed(value = {"user"}) public String helloWorld() {
        return "Hello World!";
    }
}
