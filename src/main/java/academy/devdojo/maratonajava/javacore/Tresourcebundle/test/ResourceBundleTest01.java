package academy.devdojo.maratonajava.javacore.Tresourcebundle.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleTest01 {
    //ResourceBundle é uma forma que o Java utiliza para capturar uma mensagem baseada no local
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        ResourceBundle bundle2 = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));

        String value = bundle.getString("hello");
        String value2 = bundle.getString("good.morning");

        String value3 = bundle2.getString("hello");
        String value4 = bundle2.getString("good.morning");

        System.out.println(value);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(value4);
        // Locale("fr", "CA");
        // messages_fr_CA.properties
        // messages_fr.properties
        // messages_pt_BR.properties
        // messages_pt.properties
        // messages.properties
        System.out.println(bundle.getString("hi"));
    }
}
