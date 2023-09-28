package jakarta.tutorial.trading.rar.api;

import jakarta.resource.ResourceException;

public interface TradeConnectionFactory {

    /* Applications call this method, which delegates on the container's
     * connection manager to obtain a connection instance through
     * TradeManagedConnectionFactory */
    public TradeConnection getConnection() throws ResourceException;

}
