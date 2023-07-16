package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        // FIFO: first in, first out
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");

        while (!fila.isEmpty()) {
//            System.out.println(fila.peek()); // retorna o primeiro elemento da fila
            System.out.println(fila.poll()); // poll, ao começar a remover, da sort na fila
            System.out.println(fila);
        }

    }
}
