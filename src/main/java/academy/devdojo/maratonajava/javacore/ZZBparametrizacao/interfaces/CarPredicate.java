package academy.devdojo.maratonajava.javacore.ZZBparametrizacao.interfaces;

import academy.devdojo.maratonajava.javacore.ZZBparametrizacao.model.Car;
@FunctionalInterface // Apenas um método abstrato
public interface CarPredicate {
    boolean test(Car car);
    //(parâmetro) -> <expressão>
    //(Car car) -> car.getColor().equals("Green"); * retorna o tipo da função
    // Anônimas, funções (não estão atreladas a nenhuma classe), concisas
}
