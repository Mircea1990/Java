package jakartaee.examples.beanvalidation.nullannotation;

import jakarta.validation.constraints.Null;

/**
 * The model for the BeanValidation @Null example.
 */
public class NullModel {

    /**
     * Stores the string.
     */
    @Null(message = "This must be null") private String string;

    /**
     * Get the string.
     *
     * @return the string.
     */
    public String getString() {
        return string;
    }

    /**
     * Set the string.
     *
     * @param string the string.
     */
    public void setString(String string) {
        this.string = string;
    }
}
