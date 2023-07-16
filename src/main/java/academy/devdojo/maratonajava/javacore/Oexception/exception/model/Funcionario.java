package academy.devdojo.maratonajava.javacore.Oexception.exception.model;

public class Funcionario extends Pessoa {
    @Override
    public void salvar() throws LoginInvalidoException{
        System.out.println("Salvando funcionário.");
    }
}
