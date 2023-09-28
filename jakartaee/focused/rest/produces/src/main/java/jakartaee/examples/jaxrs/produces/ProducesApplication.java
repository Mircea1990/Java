package jakartaee.examples.jaxrs.produces;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the JAX-RS @Produces example.
 */
@ApplicationPath("rest") public class ProducesApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(ProducesResource.class);
        return classes;
    }
}
