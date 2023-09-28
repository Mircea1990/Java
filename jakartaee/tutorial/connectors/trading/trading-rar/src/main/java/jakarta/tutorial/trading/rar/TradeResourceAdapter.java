package jakarta.tutorial.trading.rar;

import java.util.logging.Logger;

import javax.transaction.xa.XAResource;

import jakarta.resource.ResourceException;
import jakarta.resource.spi.ActivationSpec;
import jakarta.resource.spi.BootstrapContext;
import jakarta.resource.spi.Connector;
import jakarta.resource.spi.ResourceAdapter;
import jakarta.resource.spi.ResourceAdapterInternalException;
import jakarta.resource.spi.TransactionSupport.TransactionSupportLevel;
import jakarta.resource.spi.endpoint.MessageEndpointFactory;

@Connector(displayName = "TradeResourceAdapter", vendorName = "Jakarta EE Tutorial",
           version = "9.0") public class TradeResourceAdapter implements ResourceAdapter {

    private static final Logger log = Logger.getLogger("TradeResourceAdapter");

    @Override public void start(BootstrapContext ctx) throws ResourceAdapterInternalException {
        log.info("[TradeResourceAdapter] start()");
    }

    @Override public void stop() {
        log.info("[TradeResourceAdapter] stop()");
    }

    /* These are called for inbound connectors */
    @Override public void endpointActivation(MessageEndpointFactory endpointFactory,
                                             ActivationSpec spec) throws ResourceException {
        log.info("[TradeResourceAdapter] endpointActivation()");
    }

    @Override
    public void endpointDeactivation(MessageEndpointFactory endpointFactory, ActivationSpec spec) {
        log.info("[TradeResourceAdapter] endpointDeactivation()");
    }

    /* This connector does not use transactions */
    @Override public XAResource[] getXAResources(ActivationSpec[] specs) throws ResourceException {
        return null;
    }

}
