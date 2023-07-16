package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        String path = "C:\\Users\\gusta\\OneDrive\\Documentos\\workspace_intellij\\file.txt";
        // Interface Path pega o cominho de um arquivo através da classe Paths com Paths.get()
        Path p1 = Paths.get("C:\\Users\\gusta\\OneDrive\\Documentos\\workspace_intellij\\file.txt");
        // Pega o caminho através de varargs
        Path p2 = Paths.get("C:\\Users\\gusta\\OneDrive\\Documentos\\workspace_intellij", "file.txt");
        // Pega o arquivo através de varargs passando a partição de o caminho
        Path p3 = Paths.get("C", "Users\\gusta\\OneDrive\\Documentos\\workspace_intellij\\file.txt");
        // Pega o arquivo via varargs passando cada pasta individualmente
        Path p4 = Paths.get("C", "Users", "gusta","OneDrive", "Documentos", "workspace_intellij", "file.txt");
        // Pega o arquivo através de variavél
        Path p5 = Paths.get(path);

        System.out.println("Path 1: " + p1.getFileName().toFile().toPath());
        System.out.println("Path 2: " + p2.getFileName());
        System.out.println("Path 3: " + p3.getFileName());
        System.out.println("Path 4: " + p4.getFileName());
        System.out.println("Path 5: " + p5.getFileName());

    }
}
