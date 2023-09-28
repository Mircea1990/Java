package jakartaee.examples.jpa.joinedInheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity @DiscriminatorValue("2") public class Dog extends Animal {

    private Integer weight;

    public Dog() {
    }

    public Dog(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}
