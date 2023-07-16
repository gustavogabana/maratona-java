package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Consumidor;
import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("William Suane");
        Consumidor consumidor2 = new Consumidor("DevDojo Academy");

        Manga manga1 = new Manga(3l, "Attack on Titan", 11.20);
        Manga manga2 = new Manga(1l, "Berserk", 9.5);
        Manga manga3 = new Manga(5l, "Hellsing Ultimate", 19.9);
        Manga manga4 = new Manga(4l, "Pokemon", 3.2);
        Manga manga5 = new Manga(2l, "Dragon ball Z", 2.99);

        Map<Consumidor, Manga> map = new LinkedHashMap<>();
        map.put(consumidor1, manga1);
        map.put(consumidor2, manga2);

        for (Map.Entry<Consumidor, Manga> x : map.entrySet()) {
            System.out.println("Consumidor: " + x.getKey().getNome() + ", Manga: " + x.getValue().getNome());
        }
    }
}
