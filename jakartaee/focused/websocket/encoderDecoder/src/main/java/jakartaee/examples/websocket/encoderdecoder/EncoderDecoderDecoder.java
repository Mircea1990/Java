package jakartaee.examples.websocket.encoderdecoder;

import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;

/**
 * The decoder.
 */
public class EncoderDecoderDecoder implements Decoder.Text<EncoderDecoder> {

    /**
     * Decode.
     *
     * @param string the string.
     * @return the EncoderDecoder object.
     * @throws DecodeException when a decode error occurs.
     */
    @Override public EncoderDecoder decode(String string) throws DecodeException {
        return new EncoderDecoder(string);
    }

    /**
     * In this example We will always decode.
     *
     * @param string the string.
     * @return true.
     */
    @Override public boolean willDecode(String string) {
        return true;
    }

    /**
     * Initialized.
     *
     * @param endpointConfig the endpoint configuration.
     */
    @Override public void init(EndpointConfig endpointConfig) {
    }

    /**
     * Destroy the decoder.
     */
    @Override public void destroy() {
    }
}
