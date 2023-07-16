package academy.devdojo.maratonajava.javacore.Hheranca.model;

public class Funcionario extends Pessoa {
    private double salario;

    static {
        System.out.println("Dentro do bloco static de funcionário");
    }

    {
        System.out.println("Dentro do bloco não static de funcionário 1");
    }

    {
        System.out.println("Dentro do bloco não static de funcionário 2");
    }

    public Funcionario(String nome) {
        super(nome);
        System.out.println("Dentro do construtor de funcionário");
    }

    public void imprime() {
        super.imprime();
        System.out.println(this.salario);
    }

    public void relatorioPagamento() {
        System.out.println("Eu " + this.nome + " recebi o salário de " + this.salario);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
