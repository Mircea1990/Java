package jakartaee.examples.jpa.id;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * The JPA class for the @Id example.
 */
@Entity public class IdExample implements Serializable {

    /**
     * Stores the id.
     */
    @Id private BigInteger id;

    /**
     * Get the id.
     *
     * @return the id.
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Set the id.
     *
     * @param id the id.
     */
    public void setId(BigInteger id) {
        this.id = id;
    }
}
