package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(7);
        Period period = Period.between(now, nowAfterTwoYears);
        Period period1 = Period.ofDays(10);
        Period period2 = Period.ofWeeks(58);
        Period period3 = Period.ofMonths(3);
        Period period4 = Period.ofYears(3);

        System.out.println(period);
        System.out.println(period1);
        System.out.println(period2);
        System.out.println(period3);
        System.out.println(period4);

        System.out.println(now.until(now.plusDays(period2.getDays()), ChronoUnit.MONTHS));
    }
}
