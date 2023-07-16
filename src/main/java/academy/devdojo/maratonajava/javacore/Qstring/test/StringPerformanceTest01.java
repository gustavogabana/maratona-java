package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringPerformanceTest01 {
    public static void main(String[] args) {

        long inicio = System.currentTimeMillis();
        concatString(30_000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + "ms");

        inicio = System.currentTimeMillis();
        concatStringBuilder(30_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo: " + (fim - inicio) + "ms");
    }

    private static void concatString(int tamanho) {
        String texto = "";
        for (int i = 0; i < tamanho; i++) {
            texto += i;
        }
    }

    private static void concatStringBuilder(int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }
}
