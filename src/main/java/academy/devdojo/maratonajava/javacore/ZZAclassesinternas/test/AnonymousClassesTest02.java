package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.model.Carro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Carro> lista = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Ferrari")));
        lista.sort(new Comparator<Carro>() { // Classe anônimas que implementa a interface Comparator
            @Override
            public int compare(Carro o1, Carro o2) {
                return o1.getNome().compareTo(o2.getNome());
            }
        });
        System.out.println(lista);
    }
}
