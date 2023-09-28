package jakartaee.examples.jpa.createquery;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The JPA class for the createQuery example.
 */
@Entity @Table(name = "create_query_row") public class CreateQueryRow implements Serializable {

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
