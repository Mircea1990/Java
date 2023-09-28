package jakartaee.examples.jpa.id;

import java.io.Serializable;
import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
