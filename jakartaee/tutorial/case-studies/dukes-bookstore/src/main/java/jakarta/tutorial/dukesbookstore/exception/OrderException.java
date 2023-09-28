package jakarta.tutorial.dukesbookstore.exception;

/**
 * <p>This application exception indicates that an order cannot be
 * completed.</p>
 */
public class OrderException extends Exception {

    private static final long serialVersionUID = -5058707185180716794L;

    public OrderException() {
    }

    public OrderException(String msg) {
        super(msg);
    }
}
