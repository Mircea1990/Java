package jakartaee.examples.jpa.id;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean used to demonstrate usage of @Id.
 */
@Named("idExampleBean") @RequestScoped public class IdExampleBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private IdExampleEjb ejb;

    /**
     * Get the list of objects (instances of IdExample).
     *
     * @return the list of objects.
     */
    public List<IdExample> getObjects() {
        return ejb.getObjects();
    }
}
