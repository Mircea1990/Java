package jakartaee.examples.jpa.column;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

/**
 * A simple EJB that gives access to the list of rows.
 */
@Stateless public class ColumnEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext private EntityManager em;

    /**
     * Get the list of rows.
     *
     * @return the list of rows.
     */
    public List<ColumnRow> getRows() {
        return em.createQuery("SELECT object(r) FROM ColumnRow AS r", ColumnRow.class)
                 .getResultList();
    }
}
