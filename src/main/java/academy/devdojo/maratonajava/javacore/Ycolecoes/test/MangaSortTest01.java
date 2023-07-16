package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(3l, "Attack on Titan", 11.20));
        mangas.add(new Manga(1l, "Berserk", 9.5));
        mangas.add(new Manga(5l, "Hellsing Ultimate", 19.9));
        mangas.add(new Manga(4l, "Pokemon", 3.2));
        mangas.add(new Manga(2l, "Dragon ball Z", 2.99));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("----------------");
        Collections.sort(mangas);
        // Collections.sort internamente chama o método compareTo da interface Comparable, que deve estar sobrescrito
        // para ordenar listas
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("-----------------------------");
        //Collections.sort(mangas, new MangaByIdComparator());
        // Recebe um objeto que implementa a interface Comparator, com o método compare sobrescrito,
        // do tipo de um objeto que implementa a interface Comparable, para passar no teste 'é um comparable' do método sort
        mangas.sort(new MangaByIdComparator());
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
