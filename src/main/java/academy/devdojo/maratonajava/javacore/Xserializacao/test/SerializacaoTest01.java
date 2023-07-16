package academy.devdojo.maratonajava.javacore.Xserializacao.test;

import academy.devdojo.maratonajava.javacore.Xserializacao.model.Aluno;
import academy.devdojo.maratonajava.javacore.Xserializacao.model.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SerializacaoTest01 {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1L, "Gustavo", "123");
        Turma turma = new Turma("Maratona Java");
        // O construtor do objeto não é utilizado no momento da deserialização
        aluno.setTurma(turma);
        serializar(aluno);
        deserializar();
    }

    // Serializar trabalha com ObjectOutputStream, porque retorna o objeto serializado
    private static void serializar(Object object) {
        // Serializar = array de bytes
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("aluno.ser")))) {
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserializar trabalha com ObjectInputStream porque recebe o objeto a ser desirializado
    private static void deserializar() {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("aluno.ser")))) {
            Object object = ois.readObject();
            System.out.println(object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
