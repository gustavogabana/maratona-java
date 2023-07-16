package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEachOrdered(n -> System.out.print(n + " "));
        System.out.println("-------------------------");
        Stream.of("Eleve ", "O", " Cosmo", "no seu Coração").map(String::toUpperCase).forEachOrdered(System.out::println);
        System.out.println("-------------------------");
        int[] num = {1, 2, 3, 4, 5};
        //Retorna um IntStream
        Arrays.stream(num).average().ifPresent(System.out::println);

        System.out.println("-------------------------");

        try (Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
            lines.filter(l -> l.contains("Java")).forEachOrdered(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
