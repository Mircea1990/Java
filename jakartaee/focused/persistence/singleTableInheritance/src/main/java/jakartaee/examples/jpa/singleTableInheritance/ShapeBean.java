package jakartaee.examples.jpa.singleTableInheritance;

import java.io.Serializable;
import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * The bean used to demonstrate usage of @Inheritance
 */
@Named("shape") @RequestScoped public class ShapeBean implements Serializable {

    /**
     * Stores the EJB.
     */
    @Inject private ShapeEjb shapeEjb;

    private List<Circle> circles;
    private List<Rectangle> rectangles;

    /**
     * Saves two shapes of type circle and rectangle
     */
    public void saveAndLoad() {
        shapeEjb.persist();

        circles = shapeEjb.findAllCircles();
        rectangles = shapeEjb.findAllRectangles();
    }

    public List<Circle> getCircles() {
        return circles;
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }

}
