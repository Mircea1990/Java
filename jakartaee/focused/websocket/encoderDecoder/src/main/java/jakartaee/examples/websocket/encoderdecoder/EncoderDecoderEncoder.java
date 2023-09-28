package jakartaee.examples.websocket.encoderdecoder;

import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;

/**
 * The Encoder.
 */
public class EncoderDecoderEncoder implements Encoder.Text<EncoderDecoder> {

    /**
     * Encode.
     *
     * @param encoderDecoder the object.
     * @return the string.
     * @throws EncodeException when an encode error occurs.
     */
    @Override public String encode(EncoderDecoder encoderDecoder) throws EncodeException {
        return encoderDecoder.toString();
    }

    /**
     * Initialize the encoder.
     *
     * @param endpointConfig the endpoint configuration.
     */
    @Override public void init(EndpointConfig endpointConfig) {
    }

    /**
     * Destroy the encoder.
     */
    @Override public void destroy() {
    }
}
