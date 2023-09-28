package jakartaee.examples.jpa.singleTableInheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;



@Entity @DiscriminatorValue("CIRCLE") public class Circle extends Shape {

    private Float radious;

    public Circle() {
    }

    public Circle(Float radious) {
        this.radious = radious;
    }

    public Float getRadious() {
        return radious;
    }

    public void setRadious(Float radious) {
        this.radious = radious;
    }

}
