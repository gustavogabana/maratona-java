package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.model.Endereco;
import academy.devdojo.maratonajava.javacore.Hheranca.model.Funcionario;
import academy.devdojo.maratonajava.javacore.Hheranca.model.Pessoa;

public class HerancaTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Toyohisa Shimazu");
        Endereco endereco = new Endereco();
        Funcionario funcionario = new Funcionario("Oda Nobunaga");

        endereco.setRua("Rua 3");
        endereco.setCep("123456-789");

        pessoa.setCpf("123.456.789-10");
        pessoa.setEndereco(endereco);

        pessoa.imprime();
        System.out.println("-------------------------");

        funcionario.setCpf("098.765.432-10");
        funcionario.setEndereco(endereco);
        funcionario.setSalario(7000.00);

        funcionario.imprime();
        System.out.println("--------------------------");

        funcionario.relatorioPagamento();
    }
}
