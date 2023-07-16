package academy.devdojo.maratonajava.javacore.Uregex.test;

public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "Levi, Eren, Mikasa, true, 200";
        String[] nomes = texto.split(",");// Retorna os tokens baseado no delimitador
        for (String nome : nomes) {
            System.out.println(nome.trim());
        }

    }
}
