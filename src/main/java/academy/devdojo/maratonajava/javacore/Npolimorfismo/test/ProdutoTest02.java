package academy.devdojo.maratonajava.javacore.Npolimorfismo.test;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Computador;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Tomate;

public class ProdutoTest02 {
    public static void main(String[] args) {
        Produto produto = new Computador("Ryzen 9", 3000.00); // Polimorfismo

        System.out.println(produto.getNome());
        System.out.println(produto.getValor());
        System.out.println(produto.calcularImposto());

        Produto produto2 = new Tomate("Americano", 20); // Polimorfismo

        System.out.println(produto2.getNome());
        System.out.println(produto2.getValor());
        System.out.println(produto2.calcularImposto());
    }
}
