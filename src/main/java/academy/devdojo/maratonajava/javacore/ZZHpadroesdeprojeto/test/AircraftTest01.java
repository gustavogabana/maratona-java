package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model.Aircraft;

public class AircraftTest01 {
    public static void main(String[] args) {
        bookSeat("1A");
        bookSeat("1B");
    }

    public static void bookSeat(String seat) {
        Aircraft aircraft = new Aircraft("787-900");
        System.out.println(aircraft.bookSeat(seat));
    }
}
