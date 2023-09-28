package jakartaee.examples.jaxrs.defaultvalue;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the JAX-RS @DefaultValue example.
 */
@ApplicationPath("rest") public class DefaultValueApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(DefaultValueResource.class);
        return classes;
    }
}
