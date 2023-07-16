package academy.devdojo.maratonajava.introduction;

public class Aula05EstruturasCondicionais03 {
    public static void main(String[] args) {
        // Doar se salário > 5000
        double salario = 6000;
        String mensagemDoar = "Eu vou doar 500.";
        String mensagemNaoDoar = "Não doarei.";
        // (condição) ? verdadeiro : falso
        String resultado = salario > 5000 ? mensagemDoar : mensagemNaoDoar;

        System.out.println(resultado);
    }
}
