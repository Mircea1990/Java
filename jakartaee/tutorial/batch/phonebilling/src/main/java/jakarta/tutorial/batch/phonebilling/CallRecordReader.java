package jakarta.tutorial.batch.phonebilling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

import jakarta.batch.api.chunk.ItemReader;
import jakarta.batch.runtime.context.JobContext;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.tutorial.batch.phonebilling.items.CallRecord;

/* Reader batch artifact.
 * Reads call records from the input log file.
 */
@Dependent @Named("CallRecordReader") public class CallRecordReader implements ItemReader {

    @Inject JobContext jobCtx;
    private ItemNumberCheckpoint checkpoint;
    private String fileName;
    private BufferedReader breader;

    public CallRecordReader() {
    }

    @Override public void open(Serializable ckpt) throws Exception {
        /* Use the checkpoint provided if this is a restart */
        if (ckpt == null)
            checkpoint = new ItemNumberCheckpoint();
        else
            checkpoint = (ItemNumberCheckpoint) ckpt;

        /* Read the input file up to the checkpoint without processing */
        fileName = jobCtx.getProperties().getProperty("log_file_name");
        breader = new BufferedReader(new FileReader(fileName));
        for (int i = 0; i < checkpoint.getItemNumber(); i++)
            breader.readLine();
    }

    @Override public void close() throws Exception {
        breader.close();
    }

    @Override public Object readItem() throws Exception {
        /* Read a line from the log file and
         * create a CallRecord from JSON */
        String callEntryJson = breader.readLine();
        if (callEntryJson != null) {
            checkpoint.nextItem();
            return new CallRecord(callEntryJson);
        } else
            return null;
    }

    @Override public Serializable checkpointInfo() throws Exception {
        return checkpoint;
    }

}
