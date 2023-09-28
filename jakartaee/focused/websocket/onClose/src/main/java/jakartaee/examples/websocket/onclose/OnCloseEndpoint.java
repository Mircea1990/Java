package jakartaee.examples.websocket.onclose;

import java.io.IOException;

import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * The ServerEndpoint for the @OnClose example.
 */
@ServerEndpoint("/echo") public class OnCloseEndpoint {

    /**
     * Handle the text message.
     *
     * @param session the session.
     * @param message the message.
     * @throws IOException when an I/O error occurs.
     */
    @OnMessage public void onMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
        session.close();
    }

    /**
     * Handle to onOpen.
     *
     * @param session the session.
     * @throws IOException when an I/O error occurs.
     */
    @OnOpen public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText("Opening connection");
    }
}
