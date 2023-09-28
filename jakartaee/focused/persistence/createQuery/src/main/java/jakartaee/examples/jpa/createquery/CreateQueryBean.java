package jakartaee.examples.jpa.createquery;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean for the createQuery example.
 */
@Named("createQueryBean") @RequestScoped public class CreateQueryBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private CreateQueryEjb ejb;

    /**
     * Get all the rows.
     *
     * @return all the rows.
     */
    public List<CreateQueryRow> getRows() {
        return ejb.getRows();
    }
}
