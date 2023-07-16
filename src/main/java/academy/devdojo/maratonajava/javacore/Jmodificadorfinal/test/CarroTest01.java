package academy.devdojo.maratonajava.javacore.Jmodificadorfinal.test;

import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.model.Carro;
import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.model.Comprador;
import academy.devdojo.maratonajava.javacore.Jmodificadorfinal.model.Ferrari;

public class CarroTest01 {
    public static void main(String[] args) {
        Carro carro = new Carro();
        Comprador comprador = new Comprador();
        Ferrari ferrari = new Ferrari();

        System.out.println(Carro.VELOCIDADE_LIMITE);
        System.out.println(carro.COMPRADOR);
        carro.COMPRADOR.setNome("Kuririn");
        System.out.println(carro.COMPRADOR);
        ferrari.setNome("Enzo");
        ferrari.imprime();
    }
}
