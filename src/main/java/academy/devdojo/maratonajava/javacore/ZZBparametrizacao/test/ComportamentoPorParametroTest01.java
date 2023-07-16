package academy.devdojo.maratonajava.javacore.ZZBparametrizacao.test;

import academy.devdojo.maratonajava.javacore.ZZBparametrizacao.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> cars = List.of(new Car("Black", 2023), new Car("Green", 2020), new Car("Red", 2019));

    public static void main(String[] args) {
        System.out.println(filterGreenCar(cars));
        System.out.println(filterCarByColor(cars, "Green"));
        System.out.println(filterCarByColor(cars, "Red"));
        System.out.println(filterCarByYear(cars, 2023));
    }

    private static List<Car> filterGreenCar(List<Car> cars) {
        List<Car> greenCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals("Green")) {
                greenCars.add(car);
            }
        }
        return greenCars;
    }

    private static List<Car> filterCarByColor(List<Car> cars, String color) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }

    private static List<Car> filterCarByYear(List<Car> cars, int year) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() <= year) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
