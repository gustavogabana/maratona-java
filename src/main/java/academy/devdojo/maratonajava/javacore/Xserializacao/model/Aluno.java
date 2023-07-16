package academy.devdojo.maratonajava.javacore.Xserializacao.model;

import java.io.*;

public class Aluno implements Serializable {
    // Interface flag: sem métodos, serve para passar no teste 'é um'.
    private long id;
    private String nome;
    private transient Turma turma;
    private transient String password; // Transient: será ignordo na serialização
    private static String nomeEscola = "DevDojo Academy"; // Não é serializado pois é static (pertence à classe e não ao objeto)

    public Aluno(long id, String nome, String password) {
        System.out.println("Dentro do construtor.");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    // Métodos para seralizar um objeto que não implementa Serializable
    @Serial
    private void writeObejct(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeUTF(turma.getNome());
            // Escreve atributo por atributo do objeto a ser serializado manualmente
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Serial
    private void readObeject(ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();
            String nomeTurma = objectInputStream.readUTF();
            // Lê atributo por atributo do objeto a ser deserializado manualmente
            turma = new Turma(nomeTurma);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public static String getNomeEscola() {
        return nomeEscola;
    }

    public static void setNomeEscola(String nomeEscola) {
        Aluno.nomeEscola = nomeEscola;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", nomesEscola='" + nomeEscola + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }
}
