package jakartaee.examples.jpa.onetoone;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * The JPA OneToOneA class for the OneToOne annotation example.
 */
@Entity @Table(name = "onetoone_a") public class OneToOneA implements Serializable {

    /**
     * Stores the id.
     */
    @Id private Long id;

    /**
     * Stores the b.
     */
    @OneToOne(cascade = CascadeType.ALL) private OneToOneB b;

    /**
     * Get the b.
     *
     * @return the b.
     */
    public OneToOneB getB() {
        return b;
    }

    /**
     * Set the b.
     *
     * @param b the b.
     */
    public void setB(OneToOneB b) {
        this.b = b;
    }

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
