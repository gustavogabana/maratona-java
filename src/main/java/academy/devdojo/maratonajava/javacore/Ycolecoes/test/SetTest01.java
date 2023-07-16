package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
//        Set<Manga> mangas = new HashSet<>(); // Set não permite elementos duplicados dentro da coleção
        Set<Manga> mangas = new LinkedHashSet<>(); // Mantêm a ordem de inserção
        mangas.add(new Manga(3l, "Attack on Titan", 11.20, 2));
        mangas.add(new Manga(1l, "Berserk", 9.5, 5));
        mangas.add(new Manga(5l, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(4l, "Pokemon", 3.2, 0));
        mangas.add(new Manga(2l, "Dragon ball Z", 2.99, 0));

        // Não existe index[x], a interface Set/HashSet não é indexada
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }
}
