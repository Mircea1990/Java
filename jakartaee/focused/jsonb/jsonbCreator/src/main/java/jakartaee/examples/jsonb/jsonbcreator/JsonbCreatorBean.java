package jakartaee.examples.jsonb.jsonbcreator;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.JsonbBuilder;

/**
 * The request scoped bean for the JSON-B @JsonbCreator example.
 */
@Named @RequestScoped public class JsonbCreatorBean {

    /**
     * Stores the output.
     */
    private String output;

    /**
     * Get the output.
     *
     * @return the output.
     */
    public String getOutput() {
        return output;
    }

    /**
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        JsonbBuilder builder = JsonbBuilder.newBuilder();
        JsonbCreatorExample example = builder.build().fromJson("{\"integer\":\"1234\"}",
                                                               JsonbCreatorExample.class);
        output = String.valueOf(example.getInt());
        return "";
    }
}
