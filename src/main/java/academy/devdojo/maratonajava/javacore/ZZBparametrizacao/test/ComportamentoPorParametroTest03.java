package academy.devdojo.maratonajava.javacore.ZZBparametrizacao.test;

import academy.devdojo.maratonajava.javacore.ZZBparametrizacao.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {
    private static List<Car> cars = List.of(new Car("Black", 2023), new Car("Green", 2020), new Car("Red", 2019));

    public static void main(String[] args) {
        List<Car> greenCarsLambda = filter(cars, car -> car.getColor().equals("Green"));
        System.out.println(greenCarsLambda);

        List<Car> carsByYear = filter(cars, car -> car.getYear() < 2023);
        System.out.println(carsByYear);

        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(filter(nums, n -> n >= 3)); // Condição como parâmetro
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }
        return filteredList;
    }
}
