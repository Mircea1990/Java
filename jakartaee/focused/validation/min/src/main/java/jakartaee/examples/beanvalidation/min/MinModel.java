package jakartaee.examples.beanvalidation.min;

import jakarta.validation.constraints.Min;

/**
 * A model class for the BeanValidation @Min example.
 */
public class MinModel {

    /**
     * Stores the value.
     */
    @Min(value = 4) private Integer value;

    /**
     * Get the value.
     *
     * @return the value.
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(Integer value) {
        this.value = value;
    }
}
