package jakartaee.examples.websocket.encoderdecoder;

import jakarta.websocket.OnMessage;
import jakarta.websocket.server.ServerEndpoint;

/**
 * An Encoder/Decoder example.
 */
@ServerEndpoint(encoders = {EncoderDecoderEncoder.class}, decoders = {EncoderDecoderDecoder.class},
                value = "/echo") public class EncoderDecoderEndpoint {

    /**
     * Handle the Encoder/Decoder message.
     *
     * @param message the message.
     * @return the message.
     */
    @OnMessage public EncoderDecoder onMessage(EncoderDecoder message) {
        return message;
    }
}
