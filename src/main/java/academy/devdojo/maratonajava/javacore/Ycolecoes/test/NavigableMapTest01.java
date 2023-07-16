package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Consumidor;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main (String[] args) {
        NavigableMap<String, String> map = new TreeMap<>(); // TreeMap ordena os elementos pela key
        map.put("A", "Letra A");
        map.put("D", "Letra D");
        map.put("B", "Letra B");
        map.put("C", "Letra C");
        map.put("E", "Letra E");

        for (Map.Entry<String, String> letra : map.entrySet()) {
            System.out.println("Chave: " + letra.getKey() + ", " + letra.getValue());
        }

        // Headmap está likado à lista original, portanto qualquer alteração feita altera a lista
        System.out.println(map.headMap("C")); // Retorna todos anteriores à chave passada
        System.out.println(map.headMap("C", true)); // Retorna todos anteriores à chave passada incluindo a mesma

        System.out.println("-------------------------------------");

        Consumidor consumidor1 = new Consumidor("William Suane");
        Consumidor consumidor2 = new Consumidor("DevDojo Academy");

        NavigableMap<String, Consumidor> mapConsumidor = new TreeMap<>();
        mapConsumidor.put("A", consumidor1);
        mapConsumidor.put("B", consumidor2);

        for (Map.Entry<String, Consumidor> consumer : mapConsumidor.entrySet()) {
            System.out.println("Key: " + consumer.getKey() + ", " + consumer.getValue().getNome());
        }
    }
}
