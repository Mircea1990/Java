package jakartaee.examples.jsonb.jsonbproperty;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 * A @JsonbProperty example.
 */
public class JsonbPropertyExample {

    /**
     * Stores the string.
     */
    @JsonbProperty("another_name") private String name;

    /**
     * Get the string.
     *
     * @return the string.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the string.
     *
     * @param name the string.
     */
    public void setName(String name) {
        this.name = name;
    }
}
