package academy.devdojo.maratonajava.javacore.Minterface.model;

public class DatabaseLoader implements DataLoader, DataRemover {

    // private -> default -> protected -> public
    @Override
    public void load() {
        System.out.println("Carregando dados do Banco de Dados... ");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do Banco de Dados... ");
    }

    @Override
    public void checkPermission() {
        System.out.println("Checando permissões no banco de dados... ");
    }

    public static void retrieveMaxDataSize() {
        System.out.println("Dentro do retrieveMaxDataSize da classe DatabaseLoader.");
    }
}
