package jakarta.tutorial.web.dukeetf;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.Timeout;
import jakarta.ejb.TimerConfig;
import jakarta.ejb.TimerService;

/* Updates price and volume information every second */
@Startup @Singleton public class PriceVolumeBean {
    private static final Logger logger = Logger.getLogger("PriceVolumeBean");
    /* Use the container's timer service */
    @Resource TimerService tservice;
    private Random random;
    private DukeETFServlet servlet;
    private volatile double price = 100.0;
    private volatile int volume = 300000;

    @PostConstruct public void init() {
        /* Intialize the EJB and create a timer */
        logger.log(Level.INFO, "Initializing EJB.");
        random = new Random();
        servlet = null;
        tservice.createIntervalTimer(1000, 1000, new TimerConfig());
    }

    public void registerServlet(DukeETFServlet servlet) {
        /* Associate a servlet to send updates to */
        this.servlet = servlet;
    }

    @Timeout public void timeout() {
        /* Adjust price and volume and send updates */
        price += 1.0 * (random.nextInt(100) - 50) / 100.0;
        volume += random.nextInt(5000) - 2500;
        if (servlet != null)
            servlet.send(price, volume);
    }
}

