package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest02 {
    public static void main(String[] args) {
        try {
            criarNovoArquivo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void criarNovoArquivo() throws IOException {
        File file = new File("arquivo\\teste.txt");
        boolean isCriado = file.createNewFile();
        System.out.println("Arquivo criado: " + isCriado);
    }
}
