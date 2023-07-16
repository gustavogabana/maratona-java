package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> stringList = List.of("Natsu", "Alucard");
        List<Integer> integers = map(stringList, e -> e.length());
        System.out.println(integers);
        List<String> stringsUpper = map(stringList, e -> e.toUpperCase());
        System.out.println(stringsUpper);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            R r = function.apply(t);
            result.add(r);
        }
        return result;
    }
}
