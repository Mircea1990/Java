package jakartaee.examples.jsonb.formatting;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

/**
 * A request scoped bean for the formatting example.
 */
@Named @RequestScoped public class FormattingBean {

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
        JsonbConfig config = new JsonbConfig().withFormatting(true);
        JsonbBuilder builder = JsonbBuilder.newBuilder().withConfig(config);
        json = builder.build().toJson(new Formatting());
        return "";
    }
}
