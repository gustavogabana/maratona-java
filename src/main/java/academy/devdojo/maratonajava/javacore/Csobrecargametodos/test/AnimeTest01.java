package academy.devdojo.maratonajava.javacore.Csobrecargametodos.test;

import academy.devdojo.maratonajava.javacore.Csobrecargametodos.model.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime();

        anime.setTipo("TV");
        anime.setEpisodios(12);
        anime.setNome("Akudama Drive");

        anime.imprime();

        anime.init("Akudama Drive", "TV", 12, "Ação");

    }
}
