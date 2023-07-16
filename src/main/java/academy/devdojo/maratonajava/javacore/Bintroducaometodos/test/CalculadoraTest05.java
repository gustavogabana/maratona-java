package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.model.Calculadora;

public class CalculadoraTest05 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int[] numeros = {1, 2, 3, 4, 5};

        //calculadora.somaArray(numeros);
        calculadora.somaVarArgs(1, 2, 3, 4, 5, 6, 7);
        // VarArgs aceita vários elementos do mesmo tipo, como se fosse um array, porém precisa ser o último parâmetro
    }
}
