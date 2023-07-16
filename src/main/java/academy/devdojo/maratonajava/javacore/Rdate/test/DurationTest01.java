package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime afterTwoYears = LocalDateTime.now().plusYears(2);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);
        Duration between = Duration.between(now, afterTwoYears);
        Duration between1 = Duration.between(timeNow, timeMinus7Hours);
        Duration between2 = Duration.between(Instant.now(), Instant.now().plusSeconds(300000));

        Duration duration = Duration.ofDays(20);
        Duration of = Duration.of(3, ChronoUnit.DAYS);

        System.out.println(now);
        System.out.println(afterTwoYears);
        System.out.println(timeNow);
        System.out.println(timeMinus7Hours);
        System.out.println(between);
        System.out.println(between1);
        System.out.println(between2);
        System.out.println(duration);
        System.out.println(of);

        // DURATION
    }
}
