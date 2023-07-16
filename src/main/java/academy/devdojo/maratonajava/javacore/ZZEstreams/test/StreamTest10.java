package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
        Stream.iterate(1, n -> n + 2).limit(10).forEachOrdered(System.out::println);
        //Fibonacci
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEachOrdered(a -> System.out.print(Arrays.toString(a) + ", "));

        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(a -> a[0])
                .forEachOrdered(a -> System.out.print(a + ", "));

        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(1, 500))
                .limit(90)
                .forEachOrdered(System.out::print);
    }
}
