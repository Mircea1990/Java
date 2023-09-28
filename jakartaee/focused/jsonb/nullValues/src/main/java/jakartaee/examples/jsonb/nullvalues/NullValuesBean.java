package jakartaee.examples.jsonb.nullvalues;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

/**
 * A request scoped bean for using with the null values example.
 */
@Named(value = "nullValuesBean") @RequestScoped public class NullValuesBean {

    /**
     * Stores the JSON.
     */
    private String json;

    /**
     * Get the JSON.
     *
     * @return the JSON.
     */
    public String getJson() {
        return json;
    }

    /**
     * Set the JSON.
     *
     * @param json the json.
     */
    public void setJson(String json) {
        this.json = json;
    }

    /**
     * Submit.
     *
     * @return ""
     */
    public String submit() {
        JsonbConfig config = new JsonbConfig().withNullValues(Boolean.TRUE);
        JsonbBuilder builder = JsonbBuilder.newBuilder().withConfig(config);
        json = builder.build().toJson(new NullValues());
        return "";
    }
}
