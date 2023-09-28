package jakartaee.examples.beanvalidation.min;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 * A request scoped bean for the BeanValidation @Min example.
 */
@Named @RequestScoped public class MinBean {

    /**
     * Stores the min model.
     */
    private MinModel min = new MinModel();

    /**
     * Get the min model.
     *
     * @return the min model.
     */
    public MinModel getMin() {
        return min;
    }

    /**
     * Set the min model.
     *
     * @param min the min model.
     */
    public void setMin(MinModel min) {
        this.min = min;
    }

    /**
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        return "";
    }
}
