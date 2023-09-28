package jakarta.tutorial.web.websocketbot.encoders;

import java.io.StringWriter;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;
import jakarta.tutorial.web.websocketbot.messages.ChatMessage;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;


/* Encode a ChatMessage as JSON.
 * For example, (new ChatMessage("Peter","Duke","How are you?"))
 * is encoded as follows:
 * {
 *   "type": "chat",
 *   "target": "Duke",
 *   "message": "How are you?"
 * }
 */
public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {

    @Override public void init(EndpointConfig ec) {
    }

    @Override public void destroy() {
    }

    @Override public String encode(ChatMessage chatMessage) throws EncodeException {
        StringWriter swriter = new StringWriter();
        try (JsonGenerator jsonGen = Json.createGenerator(swriter)) {
            jsonGen.writeStartObject().write("type", "chat").write("name", chatMessage.getName())
                   .write("target", chatMessage.getTarget()).write("message",
                                                                   chatMessage.getMessage())
                   .writeEnd();
        }
        return swriter.toString();
    }
}
