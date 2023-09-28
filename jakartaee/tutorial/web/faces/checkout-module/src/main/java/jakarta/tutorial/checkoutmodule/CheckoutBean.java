package jakarta.tutorial.checkoutmodule;

import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 * Backing bean for index page.
 */
@Named @SessionScoped public class CheckoutBean implements Serializable {

    private static final long serialVersionUID = 1L;
    int numItems = 3;
    double cost = 101.25;

    public int getNumItems() {
        return numItems;
    }

    public void setNumItems(int numItems) {
        this.numItems = numItems;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
