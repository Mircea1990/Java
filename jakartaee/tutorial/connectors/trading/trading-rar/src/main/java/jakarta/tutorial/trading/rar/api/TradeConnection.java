package jakarta.tutorial.trading.rar.api;

import jakarta.resource.ResourceException;

public interface TradeConnection {

    /* Submits a trade order to the EIS */
    public TradeResponse submitOrder(TradeOrder order) throws TradeProcessingException;

    /* Closes the connection handle */
    public void close() throws ResourceException;

}
