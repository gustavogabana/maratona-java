package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import java.util.List;

public class WildCardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorroList = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatoList = List.of(new Gato(), new Gato());
        printConsulta(cachorroList);
        printConsulta(gatoList);

        List<Animal> animals = List.of();
        printConsultaAnimal(animals);

    }
        // ? -> wildcard: representa qualquer tipo
        // Porque o ? aceita qualquer tipo, se perde a possibilidade de adicionar elemento à lista, restando apenas leitura
    private static void printConsulta(List<? extends Animal> animals) {
        // Aqui, recebe animal ou qualquer um que seja filho, mas perde-se o poder de adicionar
        for (Animal animal : animals) {
            animal.consulta();
        }
    }

    private static void printConsultaAnimal(List<? super Animal> animals) {
        // Aqui, recebe animal ou qualquer um que seja maior, portanto é possível adicionar
        // A variavel de referencia deve ser o Object
        for (Object obj : animals) {
            if (obj instanceof Animal) {
                System.out.println("--------Dentro do super---------");
                ((Cachorro) obj).consulta();
            }
        }
        // Como tudo aqui é obrigatoriamente Animal, é possível instanciar classe especificas
        // Assim, é possivel adicionar elementos à lista
        Animal cachorro = new Cachorro();
        Animal gato = new Gato();
        animals.add(cachorro);
        animals.add(gato);

    }
}
