package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.List;
import java.util.Optional;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        //Reduce() retorna um optional porque a lista pode estar vazia
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);
        //Reduce() aceita um valor inicial identity e retorna um Integer
        Integer reduce = integers.stream().reduce(1, Integer::sum);
        System.out.println(reduce);

        System.out.println("------------------------------");

        integers.stream().reduce((x, y) -> x * y).ifPresent(System.out::println);

        System.out.println("------------------------------");

        integers.stream().reduce(Integer::max).ifPresent(System.out::println);
    }
}
