package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDate localDate = LocalDate.of(2024, Month.NOVEMBER, 5);
//        LocalTime localTime = LocalTime.of(9, 45, 2);
        LocalDate localDate = LocalDate.parse("2024-01-02");
        LocalTime localTime = LocalTime.parse("09:51:00");
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
        LocalDateTime localDateTime1 = localDate.atTime(localTime);
        LocalDateTime localDateTime2 = localTime.atDate(localDate);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }
}
