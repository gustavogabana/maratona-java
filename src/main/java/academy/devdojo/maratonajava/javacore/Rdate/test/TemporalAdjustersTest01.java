package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now = now.plusDays(2);
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(now);

        now = LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        System.out.println(now);

        now = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now);

        now = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(now);
    }
}
