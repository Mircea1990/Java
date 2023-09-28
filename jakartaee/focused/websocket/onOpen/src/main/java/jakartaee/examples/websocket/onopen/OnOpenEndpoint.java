package jakartaee.examples.websocket.onopen;

import java.io.IOException;
import java.util.Date;

import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * A ServerEndpoint for the @OnOpen example.
 */
@ServerEndpoint("/echo") public class OnOpenEndpoint {

    /**
     * Handle the onOpen.
     *
     * @param session the session.
     */
    @OnOpen public void onOpen(Session session) {
        try {
            session.getBasicRemote().sendText("Session started at " + new Date().toString());
        } catch (IOException ioe) {
        }
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
