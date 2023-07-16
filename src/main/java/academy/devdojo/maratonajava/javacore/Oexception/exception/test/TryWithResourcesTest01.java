package academy.devdojo.maratonajava.javacore.Oexception.exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.exception.model.Leitor1;
import academy.devdojo.maratonajava.javacore.Oexception.exception.model.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
        lerArquivo();
    }

    // Com try with resoucer, pode-se remover o catch, mas deve-se declarar o throws com a exceção
    public static void lerArquivo() {
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2();) { // Só pode ser colocado aqui quem implementa a interface Closable

        } catch (IOException e) {

        }
    }

    public static void lerArquivo2() {
        Reader reader = null;
        try {
            reader = new BufferedReader(new FileReader("Teste.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
