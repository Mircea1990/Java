package jakartaee.examples.faces.requestscoped;

import java.util.Date;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

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
