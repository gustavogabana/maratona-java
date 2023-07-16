package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");
        try (FileReader fileReader = new FileReader(file)) {
            // Retorna o número correspondente da ASCII Table
            //char[] in = new char[10];
            //fileReader.read(in);
            //for (char c : in) {
            //    System.out.print(c);
            //}

            int i;
            while ((i = fileReader.read()) != -1) {
                System.out.print((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
