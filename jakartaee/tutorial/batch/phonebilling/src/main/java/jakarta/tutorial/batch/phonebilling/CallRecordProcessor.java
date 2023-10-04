package jakarta.tutorial.batch.phonebilling;

import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.batch.runtime.context.JobContext;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.tutorial.batch.phonebilling.items.CallRecord;

import java.math.BigDecimal;

/* Processor batch artifact.
 * Calculate the price of every call.
 */
@Dependent @Named("CallRecordProcessor") public class CallRecordProcessor implements ItemProcessor {

    @Inject JobContext jobCtx;
    double airPrice;

    public CallRecordProcessor() {
    }

    @Override public Object processItem(Object obj) throws Exception {
        CallRecord call;
        double callPrice;

        /* Calculate the price of this call */
        String s_airPrice = jobCtx.getProperties().getProperty("airtime_price");
        airPrice = Double.parseDouble(s_airPrice);
        call = (CallRecord) obj;
        callPrice = airPrice * (1.0 * call.getMinutes() + call.getSeconds() / 60.0);
        call.setPrice(BigDecimal.valueOf(callPrice));
        return call;
    }
}
