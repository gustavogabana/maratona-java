package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "William Suane"; // cria string no pool de strings
        nome.concat(" DevDojo"); // Cria string no pool de strings
        nome.substring(0,3); // cria string no pool de strings
        System.out.println(nome);

        StringBuilder sb = new StringBuilder("William Suane");
        sb.append(" DevDojo").append(" Academy");
        sb.substring(0, 2); // Não altera pois retorna uma string ao invés de stringBuilder
        sb.reverse();
        sb.reverse();
        System.out.println(sb);
    }
}
