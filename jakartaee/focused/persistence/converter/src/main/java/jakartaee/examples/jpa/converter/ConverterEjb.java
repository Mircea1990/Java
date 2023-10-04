package jakartaee.examples.jpa.converter;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

/**
 * The EJB used to demonstrate usage of @Converter.
 */
@Stateless public class ConverterEjb {

    /**
     * Stores the persistence context.
     */
    @PersistenceContext private EntityManager em;

    /**
     * Get the converter example.
     *
     * @return the converter example.
     */
    public ConverterExample getConverterExample() {
        List<ConverterExample> result = em.createQuery(
                                                  "SELECT object(r) FROM ConverterExample AS r",
                                                  ConverterExample.class)
                                          .getResultList();
        if (result.isEmpty()) {
            ConverterExample row = new ConverterExample();
            row.setId(1L);
            row.setColumn(new ConverterAttribute(1234L));
            em.persist(row);
            result = em.createQuery("SELECT object(r) FROM ConverterExample AS r",
                                    ConverterExample.class).getResultList();
        }
        return result.get(0);
    }
}
