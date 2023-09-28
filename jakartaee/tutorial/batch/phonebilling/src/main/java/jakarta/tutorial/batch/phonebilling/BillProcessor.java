package jakarta.tutorial.batch.phonebilling;

import java.math.BigDecimal;

import jakarta.batch.api.chunk.ItemProcessor;
import jakarta.batch.runtime.context.JobContext;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.tutorial.batch.phonebilling.items.PhoneBill;

/* Processor artifact for bills.
 * Compute amount and total for each bill
 */
@Dependent @Named("BillProcessor") public class BillProcessor implements ItemProcessor {

    @Inject JobContext jobCtx;

    @Override public Object processItem(Object billObject) throws Exception {

        String s_taxRate = jobCtx.getProperties().get("tax_rate").toString();
        double taxRate = Double.parseDouble(s_taxRate);
        PhoneBill bill = (PhoneBill) billObject;
        bill.calculate(new BigDecimal(taxRate));
        return bill;
    }

}
