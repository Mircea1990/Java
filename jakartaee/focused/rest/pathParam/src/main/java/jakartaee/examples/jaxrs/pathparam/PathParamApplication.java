package jakartaee.examples.jaxrs.pathparam;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the JAX-RS @PathParam example.
 */
@ApplicationPath("rest") public class PathParamApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(PathParamResource.class);
        return classes;
    }
}
