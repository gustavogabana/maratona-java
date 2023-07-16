package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>(6);
        mangas.add("Attack on Titan");
        mangas.add("Berserk");
        mangas.add("Hellsing Ultimate");
        mangas.add("Pokemon");
        mangas.add("Dragon ball Z");

        Collections.sort(mangas);

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.21);
        dinheiros.add(23d);
        dinheiros.add(21.21);
        dinheiros.add(98.10);

        for (String manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("Lista antes do sort: " + dinheiros);
        Collections.sort(dinheiros);
        System.out.println("Lista depois do sort: " + dinheiros);
    }
}
