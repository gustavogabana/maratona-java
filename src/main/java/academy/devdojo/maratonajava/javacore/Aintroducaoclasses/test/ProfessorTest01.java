package academy.devdojo.maratonajava.javacore.Aintroducaoclasses.test;

import academy.devdojo.maratonajava.javacore.Aintroducaoclasses.model.Professor;

public class ProfessorTest01 {
    public static void main(String[] args) {
        Professor professor = new Professor();
        professor.nome = "Mestre Kami";
        professor.idade = 70;
        professor.sexo = 'M';

        System.out.println(professor.nome);
        System.out.println(professor.idade);
        System.out.println(professor.sexo);
    }
}
