package jakartaee.examples.websocket.onerror;

import java.io.IOException;

import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * A ServerEndpoint for the @OnError example.
 */
@ServerEndpoint("/echo") public class OnErrorEndpoint {

    /**
     * Handle the on open event.
     *
     * @param session the session.
     * @throws IOException when an I/O error occurs.
     */
    @OnOpen public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText("Open for business");
    }

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
