package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Televisao;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Tomate;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.service.CalculadoraImposto;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7", 11000.00);
        Tomate tomate = new Tomate("Tomate Siciliano", 10);
        Televisao televisao = new Televisao("Samsung 50\"", 5000.00);

        // É possível chamar o método através da classe porque os métodos são static, qual seja,
        // são da classe e não do objeto, e, os métodos não acessam nenhum atributo de classe.

        CalculadoraImposto.calcularImposto(computador);
        System.out.println();
        CalculadoraImposto.calcularImposto(tomate);
        System.out.println();
        CalculadoraImposto.calcularImposto(televisao);
    }
}
