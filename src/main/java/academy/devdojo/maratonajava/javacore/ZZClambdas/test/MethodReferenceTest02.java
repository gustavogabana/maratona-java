package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.model.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

//Reference to an instance of a method of a particular object
public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime("Hellsing", 900), new Anime("Naruto", 500)));
        animeList.sort(animeComparators::compareByEpisodesNonStatic); //Method reference
        animeList.sort((a1, a2) -> animeComparators.compareByEpisodesNonStatic(a1, a2));// Lambda
        System.out.println(animeList);
    }
}
