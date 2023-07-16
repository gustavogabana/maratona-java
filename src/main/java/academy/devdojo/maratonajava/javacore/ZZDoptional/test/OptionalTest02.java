package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.model.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repository.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> byTitle = MangaRepository.findByTitle("Boku no Hero");
        byTitle.ifPresent(m -> m.setTitle(m.getTitle() + " 2"));
        System.out.println(byTitle);

        Manga mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        // orElse extrai o objeto do wrapper Optional
        System.out.println(mangaById);

        Manga newManga = MangaRepository.findByTitle("Berserk").orElseGet(() -> new Manga(3, "Berserk", 30));

        System.out.println(newManga);
    }
}
