package jakartaee.examples.jaxrs.queryparam;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * The application for the JAX-RS @QueryParam example.
 */
@ApplicationPath("rest") public class QueryParamApplication extends Application {

    /**
     * Get the classes.
     *
     * @return the classes.
     */
    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(QueryParamResource.class);
        return classes;
    }
}
