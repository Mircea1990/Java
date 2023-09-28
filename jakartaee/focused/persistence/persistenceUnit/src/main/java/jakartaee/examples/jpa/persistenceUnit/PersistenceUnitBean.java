package jakartaee.examples.jpa.persistenceUnit;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean used to demonstrate usage of @PersistenceUnit.
 */
@Named("persistenceUnitBean") @RequestScoped public class PersistenceUnitBean
        implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private PersistenceUnitEjb ejb;

    /**
     * Get the rows (instances of PersistenceUnitRow).
     *
     * @return the rows.
     */
    public List<PersistenceUnitRow> getRows() {
        return ejb.getRows();
    }
}
