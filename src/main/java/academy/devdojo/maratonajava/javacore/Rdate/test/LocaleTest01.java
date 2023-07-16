package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest01 {
    public static void main(String[] args) {
        // Padrão lingua/país baseadas nas ISOs do construtor
        Locale localeItaly = new Locale("it", "IT");
        Locale localeCH = new Locale("it", "CH");
        Locale localeIN = new Locale("hi", "IN");
        Locale localeJp = new Locale("ja", "JP");

        Calendar calendar = Calendar.getInstance();
        DateFormat dfItaly = DateFormat.getDateInstance(DateFormat.FULL, localeItaly);
        DateFormat dfCh = DateFormat.getDateInstance(DateFormat.FULL, localeCH);
        DateFormat dfIn = DateFormat.getDateInstance(DateFormat.FULL, localeIN);
        DateFormat dfJp = DateFormat.getDateInstance(DateFormat.FULL, localeJp);

        System.out.println("Itália: " + dfItaly.format(calendar.getTime()));
        System.out.println("Suíça: " + dfCh.format(calendar.getTime()));
        System.out.println("Índia: " + dfIn.format(calendar.getTime()));
        System.out.println("Japão: " + dfJp.format(calendar.getTime()));
    }
}
