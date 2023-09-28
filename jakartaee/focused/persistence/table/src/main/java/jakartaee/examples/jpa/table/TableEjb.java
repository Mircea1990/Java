package jakartaee.examples.jpa.table;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * A simple EJB that gives access to the list of rows.
 */
@Stateless public class TableEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext private EntityManager em;

    /**
     * Get the list of rows.
     *
     * @return the list of rows.
     */
    public List<TableRow> getRows() {
        return em.createQuery("SELECT object(r) FROM TableRow AS r", TableRow.class)
                 .getResultList();
    }
}
