package jakartaee.examples.ejb.remoteejb;

import jakarta.ejb.Remote;

/**
 * The remote EJB interface.
 */
@Remote public interface RemoteEjb {

    /**
     * Hello world.
     *
     * @return "Hello World!"
     */
    String helloWorld();
}
