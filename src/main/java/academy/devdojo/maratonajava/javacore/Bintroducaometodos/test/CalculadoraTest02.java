package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.model.Calculadora;

public class CalculadoraTest02 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        calculadora.multiplicaDoisNumeros(5, 4.5F);
        double result = calculadora.divideDoisNumeros(47.9, 5.96);
        System.out.println(result);
    }
}
