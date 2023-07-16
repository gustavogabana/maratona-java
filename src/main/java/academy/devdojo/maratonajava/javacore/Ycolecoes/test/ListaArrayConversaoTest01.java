package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        Integer[] listToArray = numeros.toArray(new Integer[0]);
        System.out.println("Lista para Array: " + Arrays.toString(listToArray));

        System.out.println("----------------------------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0, 12);
        System.out.println("Array original: " + Arrays.toString(numerosArray));
        System.out.println("Array para Lista: " + arrayToList.toString());

        System.out.println("----------------------------------");

        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
        System.out.println(numerosList);
        numerosList.add(0, 1);
        System.out.println(numerosList);

        System.out.println("----------------------------------");

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5); // Cria uma List ArrayList em uma linha com Arrays.asList
        List<String> strings = List.of("1", "2"); // Cria uma List com List.of, versão 11 do Java
    }
}
