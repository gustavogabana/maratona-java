package academy.devdojo.maratonajava.javacore.Npolimorfismo.service;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Produto;
import academy.devdojo.maratonajava.javacore.Npolimorfismo.model.Tomate;

public class CalculadoraImposto {
    public static void calcularImposto(Produto produto) {
        System.out.println("Relatório de Imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Valor: " + produto.getValor());
        System.out.println("Imposto: " + imposto);
        if (produto instanceof Tomate) { // Verifica se o que está vindo como produto é uma instância de Tomate
            Tomate tomate = (Tomate) produto; // Cast
            System.out.println("Data de validade: " + (((Tomate) produto).getDataValidade())); // Cast direto
        }
    }
}
