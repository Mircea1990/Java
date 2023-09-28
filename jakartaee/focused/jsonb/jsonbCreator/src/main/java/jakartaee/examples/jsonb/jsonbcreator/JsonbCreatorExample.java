package jakartaee.examples.jsonb.jsonbcreator;

import jakarta.json.bind.annotation.JsonbCreator;
import jakarta.json.bind.annotation.JsonbProperty;

/**
 * The model object for the JSON-B @JsonbCreator example.
 */
public class JsonbCreatorExample {

    /**
     * Stores the integer.
     */
    private int integer;

    /**
     * Constructor.
     *
     * @param integerString the integer in string format.
     */
    @JsonbCreator public JsonbCreatorExample(@JsonbProperty("integer") String integerString) {
        integer = Integer.valueOf(integerString);
    }

    /**
     * Get the date.
     *
     * @return the date.
     */
    public int getInt() {
        return integer;
    }
}
