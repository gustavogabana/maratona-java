package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {
        Date date = new Date(); // Long representando milisegundos desde 01/01/1970
        date.setTime(date.getTime() + 3_600_000); // adiciona 1 hora em milisegundos
        System.out.println(date);
    }
}
