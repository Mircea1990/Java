package jakartaee.examples.jpa.onetomany;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * The JPA OneToManyB class for the OneToMany annotation example.
 */
@Entity @Table(name = "jpa_onetomany_b") public class OneToManyB implements Serializable {

    /**
     * Stores the id.
     */
    @Id private Long id;

    /**
     * Get the a.
     *
     * @return the a.
     */
    @ManyToOne @JoinColumn(name = "a", nullable = false) private OneToManyA a;

    /**
     * Get the A.
     *
     * @return the a.
     */
    public OneToManyA getA() {
        return a;
    }

    /**
     * Set the A.
     *
     * @param a the A.
     */
    public void setA(OneToManyA a) {
        this.a = a;
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
