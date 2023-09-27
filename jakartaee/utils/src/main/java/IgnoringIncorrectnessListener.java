package src.main.java;

import com.gargoylesoftware.htmlunit.IncorrectnessListener;

/**
 * An ignoring incorrectness listener.
 *
 * <p>
 * This incorrectness listener ignores any incorrectness.
 * </p>
 */
public class IgnoringIncorrectnessListener implements IncorrectnessListener {

    @Override public void notify(String message, Object origin) {
        // TODO document why this method is empty
    }

}
