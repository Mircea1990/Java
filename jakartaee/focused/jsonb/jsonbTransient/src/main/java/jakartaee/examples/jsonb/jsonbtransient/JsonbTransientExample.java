package jakartaee.examples.jsonb.jsonbtransient;

import jakarta.json.bind.annotation.JsonbTransient;

/**
 * A @JsonbTraisnet example.
 */
public class JsonbTransientExample {

    /**
     * Stores the string.
     */
    @JsonbTransient private String string;

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
