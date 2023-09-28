package jakartaee.examples.ejb.securedremoteejb;

import jakarta.ejb.Remote;

/**
 * The secured remote EJB interface.
 */
@Remote public interface SecuredRemoteEjb {

    /**
     * Hello world.
     *
     * @return "Hello World!"
     */
    String helloWorld();
}
