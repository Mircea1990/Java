package jakarta.tutorial.traffic.eis;

import java.io.StringWriter;
import java.util.Random;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class TrafficService {

    private String[] cities = {"City1", "City2", "City3", "City4", "City5"};
    private String[] accessRoutes = {"AccessA", "AccessB", "AccessC", "AccessD", "AccessE"};
    private String[] statuses = {"GOOD", "SLOW", "CONGESTED"};
    private Random random;

    public TrafficService() {
        random = new Random();
    }

    /* Return a line with a JSON report like this:
     * {"report":[ {"city":"city_i","access":"access_j","status":"status_k"}, ... ]} */
    public String getReport() {

        StringWriter swriter = new StringWriter();
        try (JsonGenerator gen = Json.createGenerator(swriter)) {
            gen.writeStartObject();
            gen.writeStartArray("report");
            for (String city : cities) {
                for (String accessRoute : accessRoutes) {
                    int i = random.nextInt(statuses.length);
                    gen.writeStartObject();
                    gen.write("city", city);
                    gen.write("access", accessRoute);
                    gen.write("status", statuses[i]);
                    gen.writeEnd();
                }
            }
            gen.writeEnd();
            gen.writeEnd();
        }
        return swriter.toString();
    }
}
