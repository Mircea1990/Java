package jakartaee.examples.jaxrs.consumes;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the JAX-RS @Consumes example.
 */
@ApplicationPath("rest") public class ConsumesApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(ConsumesResource.class);
        return classes;
    }
}
