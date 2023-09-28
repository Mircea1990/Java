package jakartaee.examples.jpa.persistenceContext;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * The JPA class for the @PersisteneContext example.
 */
@Entity public class PersistenceContextRow implements Serializable {

    /**
     * Stores the id.
     */
    @Id private Long id;

    /**
     * Get the id.
     *
     * @return the id.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param id the id.
     */
    public void setId(Long id) {
        this.id = id;
    }
}
