package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.Instant;

public class InstantTest01 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
    }
}
