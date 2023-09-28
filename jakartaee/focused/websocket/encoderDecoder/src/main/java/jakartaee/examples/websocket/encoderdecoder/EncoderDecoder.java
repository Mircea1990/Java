package jakartaee.examples.websocket.encoderdecoder;

/**
 * The Encoder/Decoder class.
 */
public class EncoderDecoder {

    /**
     * Stores the string.
     */
    private final String string;

    /**
     * Constructor.
     *
     * @param string the string.
     */
    public EncoderDecoder(String string) {
        this.string = string;
    }

    /**
     * Return the string representation.
     *
     * @return the string representation.
     */
    @Override public String toString() {
        return string;
    }
}
