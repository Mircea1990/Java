package jakartaee.examples.websocket.annotatedserverendpoint;

import java.io.IOException;

import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * An annotated ServerEndpoint example.
 */
@ServerEndpoint("/echo") public class AnnotatedServerEndpoint {

    /**
     * Handle the text message.
     *
     * @param session the session.
     * @param message the message.
     */
    @OnMessage public void onMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException ioe) {
        }
    }
}
