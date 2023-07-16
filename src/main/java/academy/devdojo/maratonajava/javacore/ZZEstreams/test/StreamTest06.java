package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.model.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamTest06 {

    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game, No Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Kumo desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        //Algum elemento com preço maior que 8
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8));
        //Todos os elementos com preço maior que 0
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));
        //Algum elemento com que não tenha preço maior que 0
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPrice() > 0));
        //Acha qualquer elemento que atenda a condição passada pelo predicate
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).findAny().ifPresent(System.out::println);
        //Retorna o primeiro elemento da lista, na ordem, que atenda a condição passada pelo predicate
        lightNovels.stream().filter(ln -> ln.getPrice() > 3).findFirst().ifPresent(System.out::println);
        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice)) // Ordena a lista comparando por preço
                .findFirst()
                .ifPresent(System.out::println);
        //Utilizando min(), neste caso faz sentido
        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .min(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);
    }
}
