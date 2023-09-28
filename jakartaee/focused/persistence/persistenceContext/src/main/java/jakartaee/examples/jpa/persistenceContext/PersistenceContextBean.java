package jakartaee.examples.jpa.persistenceContext;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean used to demonstrate usage of @Entity.
 */
@Named("persistenceContextBean") @RequestScoped public class PersistenceContextBean
        implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private PersistenceContextEjb ejb;

    /**
     * Get the rows (instances of PersistenceContextRow).
     *
     * @return the rows.
     */
    public List<PersistenceContextRow> getRows() {
        return ejb.getRows();
    }
}
