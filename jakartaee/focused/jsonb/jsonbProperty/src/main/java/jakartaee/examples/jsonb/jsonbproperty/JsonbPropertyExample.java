package jakartaee.examples.jsonb.jsonbproperty;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 * A @JsonbProperty example.
 */
public class JsonbPropertyExample {

    /**
     * Stores the string.
     */
    @JsonbProperty("another_name") private String string;

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
