package jakarta.tutorial.dukestutoring.util;

import java.util.Locale;
import java.util.ResourceBundle;


public enum StatusType {
    IN, OUT, PARK;

    public String toString(Locale locale) {
        ResourceBundle res = ResourceBundle.getBundle(
                "jakarta.tutorial.dukestutoring.util.StatusMessages", locale);
        return res.getString(name() + ".string");
    }

    @Override public String toString() {
        Locale locale = Locale.getDefault();
        ResourceBundle res = ResourceBundle.getBundle(
                "jakarta.tutorial.dukestutoring.util.StatusMessages", locale);
        return res.getString(name() + ".string");
    }
}
