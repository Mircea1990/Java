package jakartaee.examples.websocket.annotatedclientendpoint;

import java.io.IOException;

import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * An annotated ServerEndpoint for the annotated ClientEndpoint example.
 */
@ServerEndpoint("/echo") public class AnnotatedClientEndpointServerEndpoint {

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
