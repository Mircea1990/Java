package jakarta.tutorial.web.websocketbot.encoders;

import java.io.StringWriter;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.tutorial.web.websocketbot.messages.JoinMessage;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;

/* Encode a JoinMessage as JSON.
 * For example, (new JoinMessage("Peter"))
 * is encoded as follows:
 * {
 *   "type": "join",
 *   "name": "Peter"
 * }
 */
public class JoinMessageEncoder implements Encoder.Text<JoinMessage> {
    @Override public void init(EndpointConfig ec) {
    }

    @Override public void destroy() {
    }

    @Override public String encode(JoinMessage joinMessage) throws EncodeException {
        StringWriter swriter = new StringWriter();
        try (JsonGenerator jsonGen = Json.createGenerator(swriter)) {
            jsonGen.writeStartObject().write("type", "join").write("name", joinMessage.getName())
                   .writeEnd();
        }
        return swriter.toString();
    }
}
