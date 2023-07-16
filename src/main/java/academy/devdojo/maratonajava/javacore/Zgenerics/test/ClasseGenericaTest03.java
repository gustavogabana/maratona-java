package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.model.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.CarroRentavelService;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"), new Carro("Fusca")));
        RentalService<Carro> rentalService = new RentalService<>(carrosDisponiveis);
        Carro carro = rentalService.buscarObjetoDisponivel();
        System.out.println("Usando carro...");
        rentalService.retornarObjetoAlugado(carro);
    }
}
