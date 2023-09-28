package jakarta.tutorial.dukestutoring.util;

import java.util.Calendar;


public class CalendarUtil {

    public CalendarUtil() {
    }

    public static void stripTime(final Calendar cal) {
        // remove all the time information
        cal.clear(Calendar.AM_PM);
        cal.clear(Calendar.HOUR_OF_DAY);
        cal.clear(Calendar.HOUR);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
    }
}
