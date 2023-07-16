package academy.devdojo.maratonajava.javacore.ZZJcrud.service;

import academy.devdojo.maratonajava.javacore.ZZJcrud.model.Producer;
import academy.devdojo.maratonajava.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.Scanner;

public class ProducerService {

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
        ProducerRepository.findByName(name).forEach(p -> System.out.printf("ID: %d NAME: %s%n", p.getId(), p.getName()));
    }

    private static void delete() {
        System.out.println("Type the id of the producer you want to delete: ");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N");
        String choice = SCANNER.nextLine();
        if ("y".equalsIgnoreCase(choice) || "yes".equalsIgnoreCase(choice)) ProducerRepository.delete(id);
    }

    private static void save() {
        System.out.println("Type the name of the producer you want to save: ");
        String name = SCANNER.nextLine();
        Producer producer = new Producer(null, name);
        ProducerRepository.save(producer);
    }

    private static void update() {
        System.out.println("Type the id of the object you want to update: ");
        String id = SCANNER.nextLine();
        Producer producerFromDb = ProducerRepository.findById(Integer.parseInt(id));
        if (producerFromDb == null || producerFromDb.getId() == null) {
            System.out.println("Producer not found!");
            return;
        }
        System.out.println("Producer found: " + producerFromDb.getName());
        System.out.println("Type the new name or press enter to keep the same: ");
        String name = SCANNER.nextLine();
        name = name.isEmpty() || name.isBlank() ? producerFromDb.getName() : name;
        ProducerRepository.update(new Producer(producerFromDb.getId(), name));
    }

}
