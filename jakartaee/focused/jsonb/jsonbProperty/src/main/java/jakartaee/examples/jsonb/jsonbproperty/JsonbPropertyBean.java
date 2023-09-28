package jakartaee.examples.jsonb.jsonbproperty;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.JsonbBuilder;

/**
 * A request scoped bean for the @JsonbProperty example.
 */
@Named @RequestScoped public class JsonbPropertyBean {

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
        JsonbPropertyExample example = new JsonbPropertyExample();
        example.setString("this_is_my_string");
        output = builder.build().toJson(example);
        return "";
    }
}
