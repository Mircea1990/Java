package jakarta.tutorial.batch.webserverlog;

import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.batch.api.listener.JobListener;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent @Named("InfoJobListener") public class InfoJobListener implements JobListener {

    private static final Logger logger = Logger.getLogger("InfoJobListener");

    public InfoJobListener() {
    }

    @Override public void beforeJob() throws Exception {
        logger.log(Level.INFO, "The job is starting");
    }

    @Override public void afterJob() throws Exception {
        logger.log(Level.INFO, "The job has finished.");
    }

}
