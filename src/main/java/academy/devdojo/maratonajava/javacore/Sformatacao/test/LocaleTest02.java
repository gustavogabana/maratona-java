package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.util.Locale;

public class LocaleTest02 {
    public static void main(String[] args) {
        System.out.println(Locale.getDefault());
        String[] isoCountries = Locale.getISOCountries();
        String[] isoLanguages = Locale.getISOLanguages();

        for (int i = 0; i < isoCountries.length; i++) {
            for (int j = 0; j < isoLanguages.length; j++) {
                System.out.print(isoCountries[i] + ": " + isoLanguages[j]);
            }
            System.out.println();
        }
    }
}
