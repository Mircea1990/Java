package jakarta.tutorial.batch.webserverlog;

import java.io.Serializable;

/* Class for checkpoint objects.
 */
public class ItemNumberCheckpoint implements Serializable {

    private static final long serialVersionUID = -7455017703127938364L;
    private long lineNum;

    public ItemNumberCheckpoint() {
        lineNum = 0;
    }

    public long getLineNum() {
        return lineNum;
    }

    public void nextLine() {
        lineNum++;
    }
}
