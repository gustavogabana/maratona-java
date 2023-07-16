package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Tomate;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.service.CalculadoraImposto;

public class ProdutoTest03 {
    public static void main(String[] args) {
        Produto produto = new Computador("Ryzen 9", 3000.00); // Polimorfismo
        Tomate tomate = new Tomate("Americano", 20);

        tomate.setDataValidade("11/12/2023");

        CalculadoraImposto.calcularImposto(tomate);
        System.out.println();
        CalculadoraImposto.calcularImposto(produto);
    }
}
