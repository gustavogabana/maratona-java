package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.model.Category;
import academy.devdojo.maratonajava.javacore.ZZEstreams.model.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.model.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest15 {

    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 10.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game, No Life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Category, DoubleSummaryStatistics> statisticsMap = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)));
        System.out.println(statisticsMap);

        //Map<Category, List<Promotion>>
        Map<Category, Set<Promotion>> categoryPromotion = lightNovels.stream()
                .collect(Collectors.groupingBy(
                        LightNovel::getCategory,
                        Collectors.mapping(ln -> ln.getPrice() > 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE,
                                Collectors.toSet())));
        System.out.println(categoryPromotion);

        Map<Category, LinkedHashSet<Promotion>> categoryLinkedHashSetMap = lightNovels.stream()
                .collect(Collectors.groupingBy(
                        LightNovel::getCategory,
                        Collectors.mapping(ln -> ln.getPrice() > 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE,
                                Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(categoryLinkedHashSetMap);
    }
}
