package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Aha uhu o devdojo é foda");
        Optional<String> optional2 = Optional.ofNullable(null);
        Optional<String> optional3 = Optional.empty();

        System.out.println(optional);
        System.out.println(optional2);
        System.out.println(optional3);

        System.out.println("--------------------");

        Optional<String> nameOptional = findName("DevDojo");
        String orElse = nameOptional.orElse("Nome não existe");
        System.out.println(orElse);
        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));

    }

    private static Optional<String> findName(String name) {
        List<String> list = List.of("William", "DevDojo");
        int i = list.indexOf(name);
        if (i != 0) {
            return Optional.of(list.get(i));
        } else {
            return Optional.empty();
        }
    }
}
