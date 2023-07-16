package academy.devdojo.maratonajava.javacore.Bintroducaometodos.test;

import academy.devdojo.maratonajava.javacore.Bintroducaometodos.model.Estudante;
import academy.devdojo.maratonajava.javacore.Bintroducaometodos.model.ImpressoraEstudante;

public class EstudanteTest01 {
    public static void main(String[] args) {
        Estudante estudante01 = new Estudante();
        Estudante estudante02 = new Estudante();
        ImpressoraEstudante impressora = new ImpressoraEstudante();

        estudante01.nome = "Midoriya";
        estudante01.idade = 150;
        estudante01.sexo = 'M';

        estudante02.nome = "Sakura";
        estudante02.idade = 50;
        estudante02.sexo = 'F';

        impressora.imprime(estudante01);
        impressora.imprime(estudante02);
        System.out.println("xxxxxxxxxxxxxxx");
        impressora.imprime(estudante01);
        impressora.imprime(estudante02);
    }
}
