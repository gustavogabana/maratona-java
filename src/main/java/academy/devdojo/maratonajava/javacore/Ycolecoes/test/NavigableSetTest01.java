package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;
import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmarthphoneMarcaComparator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga m1, Manga m2) {
        return Double.compare(m1.getPreco(), m2.getPreco());
    }
}

public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmarthphoneMarcaComparator());
        Smartphone smartphone = new Smartphone("123", "Nokia");
        set.add(smartphone);

        System.out.println(set);

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        // TreeSet irá fazer a organização do Set baseado no compareTo da classe
        mangas.add(new Manga(3l, "Attack on Titan", 11.20, 2));
        mangas.add(new Manga(1l, "Berserk", 9.5, 5));
        mangas.add(new Manga(5l, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(4l, "Pokemon", 3.2, 0));
        mangas.add(new Manga(2l, "Dragon ball Z", 2.99, 0));
        mangas.add(new Manga(10l, "Aaragon", 2.99, 0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga yuyu = new Manga(21l, "Yuyu Hakusho", 8, 5);

        // Métodos para comparação
        // lower: retorna o imediatamente menor <
        System.out.println("Lower: " + mangas.lower(yuyu));
        // floor: retorna o mesmo elemento e caso não exista o imediato abaixo dele <=
        System.out.println("Floor: " + mangas.floor(yuyu));
        // higher: retorna o imediatamente maior >
        System.out.println("Higher: " + mangas.higher(yuyu));
        // ceiling: retorna o mesmo elemento e caso não exista o imediato acima dele >=
        System.out.println("Ceiling: " + mangas.ceiling(yuyu));

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());

    }
}
