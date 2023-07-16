package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    public static void main(String[] args) throws IOException {
        // BasicFileAttributes possui métodos para retornar atributos
        // do arquivo passado através do path.
        Path path = Paths.get("pasta2/new.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        // Retorna um objeto que é um BasicFileAttributes

        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        // Retorna o horário com timezone UTC

        System.out.println("creationTime: " + creationTime);
        System.out.println("lastAccessTime: " + lastAccessTime);
        System.out.println("lastModifiedTime: " + lastModifiedTime);

        // BasicFileAttributeView permite alterar os atributos do arquivo
        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
        fileAttributeView.setTimes(lastModifiedTime, newCreationTime, creationTime);

        //Ao alterar o arquivo com BasicFileAttibuteView, tem de reler o arquivo novamente retornar a alteração
        creationTime = fileAttributeView.readAttributes().creationTime();
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();

        System.out.println("creationTime: " + creationTime);
        System.out.println("lastAccessTime: " + lastAccessTime);
        System.out.println("lastModifiedTime: " + lastModifiedTime);
    }
}
