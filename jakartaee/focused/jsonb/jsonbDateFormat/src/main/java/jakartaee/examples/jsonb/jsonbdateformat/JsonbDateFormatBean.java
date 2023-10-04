package jakartaee.examples.jsonb.jsonbdateformat;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * The request scoped bean for the JSON-B @JsonbDateFormat example.
 */
@Named @RequestScoped public class JsonbDateFormatBean {

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
        JsonbConfig config = new JsonbConfig();
        config.withLocale(Locale.US);
        JsonbBuilder builder = JsonbBuilder.newBuilder().withConfig(config);
        JsonbDateFormatExample example = new JsonbDateFormatExample();
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("MST"));
        calendar.set(2001, Calendar.SEPTEMBER, 11);
        example.setDate(calendar.getTime());
        output = builder.build().toJson(example);
        return "";
    }
}
