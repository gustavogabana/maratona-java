package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.model.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .firstName("Willaim")
                .lastName("Suane")
                .username("viradonojiraya")
                .email("william.suane@hotmail.com")
                .build();

        System.out.println(person);
    }
}
