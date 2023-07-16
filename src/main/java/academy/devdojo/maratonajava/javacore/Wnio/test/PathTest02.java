package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) {
        Path pasta = Paths.get("pasta");
        // Cria uma nova pasta no diretório atual, equivale à new File(pasta)
        // Caso o diretório pai não exista, lança IOException
        try {
            if (Files.notExists(pasta)) {
                Path directory = Files.createDirectory(pasta);
            } else {
                System.out.println("Arquivo/Diretório já existe.");
            }
            Path subPastas = Paths.get("pasta/subpasta/subsubpasta");
            Path subSubPasta = Files.createDirectories(subPastas);
            // Cria pastas novas, e não lança exception caso a pasta passada como param. já exista
            System.out.println(subSubPasta);
            Path filePath = Paths.get(subPastas.toString(), "file.txt");
            System.out.println(filePath);
            // Recebe um path com a pasta e o arquivo a ser criado dentra da pasta passada como param.
            if (Files.notExists(filePath)) {
                Path filePathCreated = Files.createFile(filePath);
                // Recebe uma var tipo Path com o caminho e o arquivo a ser criado, e cria o arquivo
                // Lança excpetion caso o arquivo já exista
                System.out.println(filePathCreated);
            }

            Path source = filePath;
            Path target = Paths.get(subPastas.toString(), "file_renamed.txt");
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            // Copia o arquivo e troca os valores do arquivo existente para o arquivo novo

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
