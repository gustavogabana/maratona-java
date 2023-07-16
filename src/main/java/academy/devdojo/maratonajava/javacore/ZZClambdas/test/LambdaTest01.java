package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {
        List<String> names = List.of("William", "Suane", "Luffy", "Zoro");
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        forEach(names, System.out::println); // Method reference -> para cada elemento passado, executa a função
        forEach(integers, i -> System.out.print(i + " ")); // Síntaxe lambda padrão
    }

    private static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }

    }
}
