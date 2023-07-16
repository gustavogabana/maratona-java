package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.*;
import java.time.chrono.JapaneseDate;
import java.util.Map;

public class ZonedTest01 {
    public static void main(String[] args) {
        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds);
        System.out.println(ZoneId.systemDefault());
        ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
        System.out.println(tokyoZone);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        ZonedDateTime zonedDateTime = now.atZone(tokyoZone);
        System.out.println(zonedDateTime);

        Instant instant = Instant.now();
        System.out.println(instant);
        ZonedDateTime zonedDateTime1 = instant.atZone(tokyoZone);
        System.out.println(zonedDateTime1);

        System.out.println(ZoneOffset.MIN);
        System.out.println(ZoneOffset.MAX);
        ZoneOffset offSetManaus = ZoneOffset.of("-04:00");
        System.out.println(offSetManaus);

        OffsetDateTime offsetDateTime = now.atOffset(offSetManaus);
        System.out.println(offsetDateTime);

        OffsetDateTime offsetDateTime1 = instant.atOffset(offSetManaus);
        System.out.println(offsetDateTime1);

        JapaneseDate japaneseDate = JapaneseDate.now();
        System.out.println(japaneseDate);

        //ZONES JAVA.UTIL
    }
}
