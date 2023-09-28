package jakartaee.examples.jaxrs.streamingoutput;

import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

17
        *The application for the StreamingOutput example.

        */

@ApplicationPath("rest") public class StreamingOutputApplication extends Application {

    17
            *
    Get the
    classes .
     *
             *@return
    the classes.
            */

    @Override public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(StreamingOutputBean.class);
        return classes;
    }
}
