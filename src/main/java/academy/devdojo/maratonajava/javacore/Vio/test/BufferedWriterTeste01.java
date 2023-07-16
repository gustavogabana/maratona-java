package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTeste01 {
    public static void main(String[] args) {
        // File, FileWriter, FileReader, BufferedWriter, BufferedReader
        File file = new File("file.txt");
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write("yes hello");
            bufferedWriter.newLine();
            bufferedWriter.write("walcome to muh file");
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
