package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {
    public static void main(String[] args) {
        // Como o queue é FIFO, é possível, com PriorityQueue, definir a prioridade
        Queue<Manga> mangas = new PriorityQueue<>(new MangaPrecoComparator().reversed());
        mangas.add(new Manga(3l, "Attack on Titan", 11.20, 2));
        mangas.add(new Manga(1l, "Berserk", 9.5, 5));
        mangas.add(new Manga(5l, "Hellsing Ultimate", 19.9, 0));
        mangas.add(new Manga(4l, "Pokemon", 3.2, 0));
        mangas.add(new Manga(2l, "Dragon ball Z", 2.99, 0));
        mangas.add(new Manga(10l, "Aaragon", 2.99, 0));

        while(!mangas.isEmpty()) {
            System.out.println(mangas.poll());
        }
        // Utiliza o comparator de preço da classe manga para remover da fila os mangas com maior preço
    }
}
