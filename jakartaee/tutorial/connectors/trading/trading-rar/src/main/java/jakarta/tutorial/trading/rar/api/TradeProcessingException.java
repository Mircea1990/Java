package jakarta.tutorial.trading.rar.api;

/* Indicates that the trade order could not be processed */
public class TradeProcessingException extends Exception {

    public TradeProcessingException(String msg) {
        super(msg);
    }
}
