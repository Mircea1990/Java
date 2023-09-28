package jakartaee.examples.beanvalidation.notnull;

import jakarta.validation.constraints.NotNull;

/**
 * The model for the BeanValidation @NotNull example.
 */
public class NotNullModel {

    /**
     * Stores the string.
     */
    @NotNull(message = "This cannot be null") private String string;

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
