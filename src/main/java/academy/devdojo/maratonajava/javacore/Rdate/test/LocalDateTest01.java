package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class LocalDateTest01 {
    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(Calendar.getInstance());
        // LocalDate tem o construtor privado,
        // portanto não é possível instânciar
        LocalDate date = LocalDate.of(2024, Month.JANUARY, 1);
        LocalDate agora = LocalDate.now();
        System.out.println(date.getYear());
        System.out.println(date.getMonthValue());
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfMonth());
        System.out.println(date.lengthOfMonth());
        System.out.println(date.isLeapYear());
        System.out.println(date.get(ChronoField.YEAR));
        System.out.println(date);
        System.out.println(agora);
        System.out.println(LocalDate.MAX);
        System.out.println(LocalDate.MIN);
    }
}
