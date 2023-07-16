package academy.devdojo.maratonajava.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/gustavo");
        Path clazz = Paths.get("/home/gustavo/devdojo/olaMundo.java");
        Path pathToClazz = dir.relativize(clazz);
        // Partindo do caminho x, va até o caminho y, no caso, dir e clazz
        System.out.println(pathToClazz);

        Path absoluto1 = Paths.get("/home/gustavo");
        Path absoluto2 = Paths.get("/user/local");
        Path absoluto3 = Paths.get("/home/gustavo/devdojo/olaMundo.java");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/temp.2021921");

        System.out.println("1: " + absoluto1.relativize(absoluto3));
        // Retorna o caminho do arquivo
        System.out.println("2: " + absoluto3.relativize(absoluto1));
        // Retorna a forma para voltar ao diretório
        System.out.println("3: " + absoluto1.relativize(absoluto2));
        // Retorna a forma para, partindo do caminho 1, chegar ao caminho 2
        System.out.println("4: " + relativo1.relativize(relativo2));
        // Retorna o próximo diretório
        System.out.println("5: " + relativo2.relativize(relativo1));
        // Retorna para voltar ao diretório anterior
        System.out.println("6: " + absoluto1.relativize(relativo1));
        // Retorna IllegalArgumentException pois o Java não sabe como chegar à um caminho relativo

    }
}
