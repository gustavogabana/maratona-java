package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Smartphone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("22222", "Pixel");
        Smartphone s3 = new Smartphone("33333", "Samsung");

        List<Smartphone> smartphones = new ArrayList<>(6);
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(s3);
        //smartphones.clear(); // Deleta o conteúdo da lista sem perder a variavél de referência

        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }

        Smartphone s4 = new Smartphone("22222", "Pixel");
        smartphones.add(0, s4); // Recebe o index e o obj para adicionar na lista

        boolean contains = smartphones.contains(s4);
        System.out.println(contains); // Retorna true pois utiliza o equals para fazer a comparação.
        int index = smartphones.indexOf(s4);// Retorna o index do objeto passado, e -1 caso o obj não exista.
        System.out.println("Index do objeto encontrado: " + index);
        System.out.println(smartphones.get(index));

    }
}
