package jakartaee.examples.jsonb.jsonbtransient;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.JsonbBuilder;

/**
 * The request scoped bean for the @JsonbTransient example.
 */
@Named @RequestScoped public class JsonbTransientBean {

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
        JsonbTransientExample example = new JsonbTransientExample();
        example.setString(
                "It does not matter what I set this to, it will not show up in the output");
        output = builder.build().toJson(example);
        return "";
    }
}
