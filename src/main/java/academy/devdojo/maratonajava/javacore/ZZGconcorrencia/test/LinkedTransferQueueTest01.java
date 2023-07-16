package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        //ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue
        TransferQueue<String> tq = new LinkedTransferQueue<>();
        System.out.println(tq.add("Gustavo"));
        System.out.println(tq.offer("Java"));
        System.out.println(tq.offer("Spring", 10, TimeUnit.SECONDS));
        tq.put("Quarkus");
        if (tq.hasWaitingConsumer()) {
            tq.transfer("Angular");
        }
        System.out.println(tq.tryTransfer("MySQL"));
        System.out.println(tq.tryTransfer("MySQL", 5, TimeUnit.SECONDS));
        System.out.println(tq.remove());
        System.out.println(tq.peek());
        System.out.println(tq.poll());
        System.out.println(tq.remove());
        System.out.println(tq.take());
        System.out.println(tq.remainingCapacity());
    }
}
