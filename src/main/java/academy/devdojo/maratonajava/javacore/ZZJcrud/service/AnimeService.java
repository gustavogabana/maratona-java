package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.model.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.model.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.AnimeRepository;

import java.util.Scanner;

public class AnimeService {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op) {
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
        }

    }

    private static void findByName() {
        System.out.println("Type the name or empty to all: ");
        String name = SCANNER.nextLine();
        AnimeRepository.findByName(name)
                .forEach(a -> System.out.printf("ID: %d NAME: %s EPISODES: %d%n", a.getId(), a.getName(), a.getEpisodes()));
    }

    private static void delete() {
        System.out.println("Type the id of the anime you want to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());

        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();

        if ("y".equalsIgnoreCase(choice) || "yes".equalsIgnoreCase(choice)) AnimeRepository.delete(id);
    }

    private static void save() {
        System.out.println("Type the name of the anime you want to save: ");
        String name = SCANNER.nextLine();

        System.out.println("Type the number of episodes: ");
        Integer episodes = Integer.parseInt(SCANNER.nextLine());

        System.out.println("Type the producer id: ");
        Integer producerId = Integer.parseInt(SCANNER.nextLine());

        AnimeRepository.save(new Anime(null, name, episodes, new Producer(producerId, null)));
    }

    private static void update() {
        System.out.println("Type the id of the object you want to update: ");
        String id = SCANNER.nextLine();
        Anime animeFromDb = AnimeRepository.findById(Integer.parseInt(id));
        if (animeFromDb == null || animeFromDb.getId() == null) {
            System.out.println("Anime not found!");
            return;
        }
        System.out.println("Anime found: " + animeFromDb.getName());

        System.out.println("Type the new name or press enter to keep the same: ");
        String name = SCANNER.nextLine();

        System.out.println("Type the new number of episodes: ");
        Integer episodes = Integer.parseInt(SCANNER.nextLine());

        name = name.isEmpty() || name.isBlank() ? animeFromDb.getName() : name;
        AnimeRepository.update(new Anime(animeFromDb.getId(), name, episodes, animeFromDb.getProducer()));
    }

}
