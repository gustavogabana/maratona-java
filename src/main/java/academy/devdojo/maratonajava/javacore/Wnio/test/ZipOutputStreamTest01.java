package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");
        zip(arquivoZip, arquivosParaZipar);
    }

    private static void zip(Path arquivoZip, Path arquivosParaZipar) {
        try (ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
             DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {
            for (Path file : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString()); // Recebe o nome do arquivo a ser zipado
                zipStream.putNextEntry(zipEntry); // Passa o arquivo para a próximo entrada
                Files.copy(file, zipStream); // Copia o conteúdo do arquivo
                zipStream.closeEntry(); // Fecha a entrada, não o stream
            }
            System.out.println("Arquivo criado com sucesso");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
