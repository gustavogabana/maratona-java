package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.model.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//Reference to a constructor
public class MethodReferenceTest04 {
    public static void main(String[] args) {
//        AnimeComparators animeComparators = new AnimeComparators();
//        Supplier<AnimeComparators> newAnimeComparators = () -> new AnimeComparators(); //Lambda

        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new; // Referência o construtor
        AnimeComparators animeComparators = newAnimeComparators.get(); // Fornece um construtor
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 40), new Anime("Naruto", 500), new Anime("One Piece", 900)));
        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);

        BiFunction<String, Integer, Anime> animeFunctionLambda = (s, i) -> new Anime(s, i); // Lambda
        BiFunction<String, Integer, Anime> animeBiFunction = Anime::new; //Method Reference
        // Recebe um parametro String, um Parametro Integer e retorna uma objeto Anime
        Anime dragonBallZ = animeBiFunction.apply("Dragon Ball Z", 150);
        System.out.println(dragonBallZ);
        Anime narutoShippuden = animeFunctionLambda.apply("Naruto Shippuden", 500);
        System.out.println(narutoShippuden);
    }
}
