package academy.devdojo.maratonajava.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDirectory = new File("pasta");
        boolean mkdir = fileDirectory.mkdir();
        System.out.println("mkdir: " + mkdir);

        // Passa a var de referência que cria o diretório junto ao nome do arquivo
        // para criar o arquivo dentro do diretório
        File file = new File(fileDirectory, "arquivo.txt");
        boolean newFile = file.createNewFile();
        System.out.println("Create new file: " + newFile);

        File renamed = new File(fileDirectory, "arquivo_renomeado.txt");
        boolean isRenamed = file.renameTo(renamed);
        System.out.println("Arquivo renomeado: " + isRenamed);

        File directoryRenamed = new File("pasta2");
        boolean direcotyIsRenamed = fileDirectory.renameTo(directoryRenamed);
        System.out.println(direcotyIsRenamed);
    }
}
