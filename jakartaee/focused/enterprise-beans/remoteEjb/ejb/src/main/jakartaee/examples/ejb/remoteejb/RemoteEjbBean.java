package jakartaee.examples.ejb.remoteejb;

import jakarta.ejb.Stateless;

/**
 * A remote stateless session bean.
 */
@Stateless(name = "remoteEjb") public class RemoteEjbBean implements RemoteEjb {

    /**
     * Hello world!
     *
     * @return "Hello World!"
     */
    @Override public String helloWorld() {
        return "Hello World!";
    }
}
