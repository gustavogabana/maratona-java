package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
    public static void main(String[] args) {
        System.out.println("Núcleos: " + Runtime.getRuntime().availableProcessors());
        long num = 10_000_000;
        sumFor(num);
        sumStreamIterate(num);
        sumParallelStreamIterate(num);
        sumLongStreamIterate(num);
        sumLongParallelStreamIterate(num);
    }

    private static void sumFor(long num) {
        System.out.println("Sum for");
        long result = 0;
        long init = System.currentTimeMillis();
        for (long i = 1; i <= num; i++) {
            result += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Tempo: " + (end - init) + "ms");
    }

    private static void sumStreamIterate(long num) {
        System.out.println("Sum StreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Tempo: " + (end - init) + "ms");
    }

    private static void sumParallelStreamIterate(long num) {
        System.out.println("Sum ParallelStreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = Stream.iterate(1L, i -> i + 1).limit(num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Tempo: " + (end - init) + "ms");
    }

    private static void sumLongStreamIterate(long num) {
        System.out.println("Sum LongStreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, num).reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Tempo: " + (end - init) + "ms");
    }

    private static void sumLongParallelStreamIterate(long num) {
        System.out.println("Sum LongParallelStreamIterate");
        long result = 0;
        long init = System.currentTimeMillis();
        result = LongStream.rangeClosed(1L, num).parallel().reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println("Tempo: " + (end - init) + "ms");
    }
}
