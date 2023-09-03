package resourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

//loading properties file in a bundle and prints the messages
public class InternationalizationDemo {

    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("resourceBundle/MessageBundle_en_US.properties", Locale.US);
        System.out.println("Message in " + Locale.US + ":" + bundle.getString("greeting"));

        //changing the default locale to indonasian
        Locale.setDefault(new Locale("in", "ID"));
        bundle = ResourceBundle.getBundle("MessageBundle");
        System.out.println("Message in " + Locale.getDefault() + ":" + bundle.getString("greeting"));

    }
}
