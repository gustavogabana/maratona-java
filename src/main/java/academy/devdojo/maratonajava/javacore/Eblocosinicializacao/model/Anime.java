package academy.devdojo.maratonajava.javacore.Eblocosinicializacao.model;

import java.sql.SQLOutput;

public class Anime {
    private String nome;
    private int[] episodios;
    // Bloco de inicialização de instância: executa toda vez que o objeto é instânciado
    // Ordem:
    // 1 - Alocado espaço em memória para o objeto
    // 2 - Cada atributo de classe é criado e inicializado com valores default ou o que for passado
    // 3 - Bloco de inicialização é executado
    // 4 - Construtor é executado
    {
        System.out.println("Dentro do bloco de inicialização.");
        episodios = new int[100];
        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i+1;
        }
    }

    public Anime() {
        for (int episodio : episodios) {
            System.out.print(episodio + " ");
        }
    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int[] getEspisodios() {
        return episodios;
    }

    public void setEspisodios(int[] espisodios) {
        this.episodios = espisodios;
    }
}
