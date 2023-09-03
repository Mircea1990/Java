package internationalizationLocalization;

import java.util.Locale;

//print display language of many locales
public class LocaleEx {

    public static void main(String[] args) {
        Locale[] locales = {new Locale("en", "US"),
                new Locale("es", "ES"), new Locale("it", "IT")};

        for (Locale locale : locales) {
            String displayLanguage = locale.getDisplayLanguage(locale);
            System.out.println(locale + ": " + displayLanguage);
        }
    }
}
