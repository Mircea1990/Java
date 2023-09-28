package jakartaee.examples.jpa.converter;

/**
 * The attribute used to demonstrate usage of @Converter.
 */
public class ConverterAttribute {

    /**
     * Stores the long.
     */
    private Long value;

    /**
     * Constructor.
     */
    public ConverterAttribute() {
    }

    /**
     * Constructor.
     *
     * @param value the value.
     */
    public ConverterAttribute(Long value) {
        this.value = value;
    }

    /**
     * Get the value.
     *
     * @return the value.
     */
    public Long getValue() {
        return value;
    }

    /**
     * Set the value.
     *
     * @param value the value.
     */
    public void setValue(Long value) {
        this.value = value;
    }
}
