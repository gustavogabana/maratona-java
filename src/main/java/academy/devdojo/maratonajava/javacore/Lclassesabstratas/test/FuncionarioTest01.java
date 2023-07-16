package academy.devdojo.maratonajava.javacore.Lclassesabstratas.test;

import academy.devdojo.maratonajava.javacore.Lclassesabstratas.model.Desenvolvedor;
import academy.devdojo.maratonajava.javacore.Lclassesabstratas.model.Gerente;

public class FuncionarioTest01 {
    // Na classe abstrata pode-se ter métodos abstratos E métodos concretos
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Nami", 5000.00);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Touya", 1200.00);

        System.out.println(gerente);
        System.out.println(desenvolvedor);

        gerente.imprime();
        desenvolvedor.imprime();
    }
}
