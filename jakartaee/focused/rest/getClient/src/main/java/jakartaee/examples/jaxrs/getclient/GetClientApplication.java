package jakartaee.examples.jaxrs.getclient;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the GET client example.
 */
@ApplicationPath("rest") public class GetClientApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(GetClientResource.class);
        return classes;
    }
}
