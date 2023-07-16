package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorioProjeto = "home/gustavo/dev";
        String arquivoTxt = "../../arquivo.txt";
        Path path1 = Paths.get(diretorioProjeto, arquivoTxt);// Recebe o diretorio e o arquivo a ser retornado
        System.out.println("Unnormalized path: " + path1);
        System.out.println("Normalized path: " + path1.normalize());
        // .normalize retorna o caminho passado os diretórios reduntantes
        Path path2 = Paths.get("/home/./gustavo/./dev/");
        System.out.println("Unnormalized path: " + path2);
        System.out.println("Normalized path: " + path2.normalize());

    }
}
