package jakartaee.examples.beanvalidation.size;

import jakarta.validation.constraints.Size;

/**
 * The model class for the BeanValidation @Size example.
 */
public class SizeModel {

    /**
     * Stores the string.
     */
    @Size(min = 4) private String string;

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
