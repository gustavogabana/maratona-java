package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Gomu", "Gomu", "No", "Mi");
        Stream<String> stream = words.stream()
                .map(w -> w.split("")) // Stream<String[]>
                .flatMap(Arrays::stream); // Stream<String>
        stream.forEach(System.out::println);
    }
}
