package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
//        List<Manga> mangas = new ArrayList<>(6);
        List<Manga> mangas = new LinkedList<>();
        mangas.add(new Manga(3l, "Attack on Titan", 11.20, 2));
        mangas.add(new Manga(1l, "Berserk", 9.5, 5));
        mangas.add(new Manga(5l, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(4l, "Pokemon", 3.2, 0));
        mangas.add(new Manga(2l, "Dragon ball Z", 2.99, 0));

//        Iterator<Manga> mangaIterator = mangas.iterator();
//        while (mangaIterator.hasNext()) {
//            if (mangaIterator.next().getQuantidade() == 0) {
//                mangaIterator.remove();
//            }
//        }
        mangas.removeIf(manga -> manga.getQuantidade() == 0); // Programação funcional
        System.out.println(mangas);
    }
}
