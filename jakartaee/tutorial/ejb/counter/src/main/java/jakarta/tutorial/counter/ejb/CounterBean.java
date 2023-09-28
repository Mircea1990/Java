package jakarta.tutorial.counter.ejb;

import jakarta.ejb.Singleton;

/**
 * CounterBean is a simple singleton session bean that records the number of hits to a web page.
 */
@Singleton public class CounterBean {
    private int hits = 1;

    // Increment and return the number of hits
    public int getHits() {
        return hits++;
    }
}
