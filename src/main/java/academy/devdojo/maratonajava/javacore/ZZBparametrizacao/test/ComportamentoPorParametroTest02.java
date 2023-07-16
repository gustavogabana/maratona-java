package academy.devdojo.maratonajava.javacore.ZZBparametrizacao.test;

import academy.devdojo.maratonajava.javacore.ZZBparametrizacao.interfaces.CarPredicate;
import academy.devdojo.maratonajava.javacore.ZZBparametrizacao.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("Black", 2023), new Car("Green", 2020), new Car("Red", 2019));

    public static void main(String[] args) {
        List<Car> greenCars = filter(cars, new CarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equals("Green");
            }
        });
        System.out.println(greenCars);

        List<Car> greenCarsLambda = filter(cars, car -> car.getColor().equals("Green"));
        System.out.println(greenCarsLambda);

        List<Car> carsByYear = filter(cars, car -> car.getYear() > 2023);
        System.out.println(carsByYear);
    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }
        return filteredCars;
    }
}
