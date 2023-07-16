package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("William Suane");
        Consumidor consumidor2 = new Consumidor("DevDojo Academy");

        Manga manga1 = new Manga(3l, "Attack on Titan", 11.20);
        Manga manga2 = new Manga(1l, "Berserk", 9.5);
        Manga manga3 = new Manga(5l, "Hellsing Ultimate", 19.9);
        Manga manga4 = new Manga(4l, "Pokemon", 3.2);
        Manga manga5 = new Manga(2l, "Dragon ball Z", 2.99);

        List<Manga> listMangaConsumidor1 = List.of(manga1, manga2, manga3);
        List<Manga> listMangaConsumidor2 = List.of(manga4, manga5);

        Map<Consumidor, List<Manga>> mapConsumidor = new LinkedHashMap<>();
        mapConsumidor.put(consumidor1, listMangaConsumidor1);
        mapConsumidor.put(consumidor2, listMangaConsumidor2);

        for (Map.Entry<Consumidor, List<Manga>> entry : mapConsumidor.entrySet()) {
            for (Manga manga : entry.getValue()) {
                System.out.println(entry.getKey().getNome() + " : " + manga.getNome());
            }
        }

    }
}
