package jakarta.tutorial.vendor;

public class SampleUtilities {

    /**
     * Monitor class for asynchronous examples.  Producer signals end of message stream; listener
     * calls allDone() to notify consumer that the signal has arrived, while consumer calls
     * waitTillDone() to wait for this notification.
     */
    public static class DoneLatch {
        boolean done = false;

        /**
         * Waits until done is set to true.
         */
        public void waitTillDone() {
            synchronized (this) {
                while (!done) {
                    try {
                        this.wait();
                    } catch (InterruptedException ie) {
                    }
                }
            }
        }

        /**
         * Sets done to true.
         */
        public void allDone() {
            synchronized (this) {
                done = true;
                this.notify();
            }
        }
    }
}
