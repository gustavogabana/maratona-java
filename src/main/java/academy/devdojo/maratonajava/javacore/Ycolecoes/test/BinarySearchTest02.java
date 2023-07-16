package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(3l, "Attack on Titan", 11.20));
        mangas.add(new Manga(1l, "Berserk", 9.5));
        mangas.add(new Manga(5l, "Hellsing Ultimate", 19.9));
        mangas.add(new Manga(4l, "Pokemon", 3.2));
        mangas.add(new Manga(2l, "Dragon ball Z", 2.99));

        Manga mangaToSearch = new Manga(2l, "Dragon ball Z", 2.99);
        //Collections.sort(mangas);
        mangas.sort(mangaByIdComparator);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println(Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator));
    }
}
