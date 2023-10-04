package jakartaee.examples.faces.requestscoped;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.Date;

/**
 * A request scoped bean.
 */
@Named(value = "requestScopedBean") @RequestScoped public class RequestScopedBean {

    /**
     * Get the time.
     *
     * @return the time.
     */
    public String getTime() {
        return new Date().toString() + " - " + System.nanoTime();
    }
}
