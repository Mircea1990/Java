package jakarta.tutorial.batch.webserverlog;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.batch.api.chunk.listener.ItemProcessListener;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import jakarta.tutorial.batch.webserverlog.items.LogLine;

@Dependent @Named("InfoItemProcessListener") public class InfoItemProcessListener
        implements ItemProcessListener {

    private static final Logger logger = Logger.getLogger("InfoItemProcessListener");

    public InfoItemProcessListener() {
    }

    @Override public void beforeProcess(Object o) throws Exception {
        LogLine logline = (LogLine) o;
        logger.log(Level.INFO, "Processing entry {0}", logline);
    }

    @Override public void afterProcess(Object o, Object o1) throws Exception {
    }

    @Override public void onProcessError(Object o, Exception excptn) throws Exception {
        LogLine logline = (LogLine) o;
        logger.log(Level.WARNING, "Error processing entry {0}", logline);
    }

}
