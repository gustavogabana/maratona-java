package academy.devdojo.maratonajava.javacore.Zgenerics.service;

import java.util.List;

public class RentalService<T> {
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel() {
        System.out.println("Buscando objeto disponível...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto: " + t);
        System.out.println("Objetos disponíveis para alugar: " + objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t) {
        System.out.println("Devolvendo objeto alugado: " + t);
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponíveis para alugar: " + objetosDisponiveis);
    }


}
