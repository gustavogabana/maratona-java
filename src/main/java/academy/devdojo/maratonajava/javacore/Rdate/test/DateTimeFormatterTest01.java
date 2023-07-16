package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // Para formatar a data com o .parse do LocalDate, informa-se a data como texto
        // + DateTimeFormatter correspondente
        LocalDate parse1 = LocalDate.parse("20230305", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse("2023-03-05+05:00", DateTimeFormatter.ISO_DATE);
        LocalDate parse3 = LocalDate.parse("2023-03-05", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parse1);
        System.out.println(parse2);
        System.out.println(parse3);

        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatBR = LocalDateTime.now().format(formatterBR);
        System.out.println("Formato BR: " + formatBR);

        DateTimeFormatter formatterGM = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String formatGM = LocalDateTime.now().format(formatterGM);
        System.out.println(formatGM);

        LocalDate parseGM = LocalDate.parse("05.März.2023", formatterGM);
        System.out.println(parseGM);
    }
}