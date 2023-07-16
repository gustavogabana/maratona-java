package academy.devdojo.maratonajava.javacore.Npolimorfismo.service;

import academy.devdojo.maratonajava.javacore.Npolimorfismo.repositorio.Repositorio;

public class RepositorioBandoDeDados implements Repositorio {
    @Override
    public void salvar() {
        System.out.println("Salvando em banco de dados.");
    }
}
