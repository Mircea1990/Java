package jakartaee.examples.jpa.singleTableInheritance;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity @DiscriminatorValue("RECT") public class Rectangle extends Shape {

    private Integer width;
    private Integer height;

    public Rectangle() {
    }

    public Rectangle(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
