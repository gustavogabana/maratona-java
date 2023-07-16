package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("home/gustavo");
        Path arquivo = Paths.get("dev/arquivo.txt");
        // sem o / no início, o caminho é considerado selativo, ou seja, a partir de onde se esta
        // com o / no inpicio, o caminho é absoluto, ou seja, a partir do root
        Path resolve = dir.resolve(arquivo);
        System.out.println(resolve);

        Path absoluto = Paths.get("/home/gustavo");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("1 " + absoluto.resolve(relativo));
        System.out.println("2 " + absoluto.resolve(file));
        System.out.println("3 " + relativo.resolve(absoluto));
        // Ao normalizar um caminho relativo com absoluto, simplismente retorna o absoluto
        System.out.println("4 " + relativo.resolve(file));
        // Ao normalizar dois paths relativos, funciona corretamente
        System.out.println("5 " + file.resolve(absoluto));
        // Retorna simplismente o path absoluto
        System.out.println("6 " + file.resolve(relativo));
        // Normaliza paths relativos sem verificar a ordem correta
    }
}
