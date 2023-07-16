package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        String nome = "William"; // String Constant Pool / String Literal
        String nome2 = "William";
        nome = nome.concat(" Suane"); // nome += " Suane"
        // Cria uma noma String: William Suane
        // e o identificador nome faz referência para esta noma String
        System.out.println(nome);
        System.out.println(nome == nome2);
        // Equals compara a referência, isto é, o objeto referênciado pelo identificador nome e nome2
        String nome3 = new String("William"); // String objeto != Literal
        System.out.println(nome2 == nome3);
        // nome2 != nome3 porque são objetos diferentes
        System.out.println(nome2 == nome3.intern());
        // Retorna a string do pool de strings, caso a string exista lá
    }
}
