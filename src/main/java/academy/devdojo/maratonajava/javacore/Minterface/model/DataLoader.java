package academy.devdojo.maratonajava.javacore.Minterface.model;

public interface DataLoader {
    int MAX_DATA_SIZE = 10; // Por padrão, todos os atributos na interface são public static final
    void load(); // Por padrão, todos os métodos na interface são public abstract
    default void checkPermission() { // default serve para adicionar métodos sem quebrar código
        System.out.println("Fazendo checagem de permissões... ");
    }

    static void retrieveMaxDataSize() { // Não pode ser sobrescrito pois é static, pertence a classe/interface
        System.out.println("Dentro do retrieveMaxDataSize da interface DataLoader.");
    }
}
