package academy.devdojo.maratonajava.introduction;

public class Aula05EstruturasCondicionais01 {
    public static void main(String[] args) {
        int idade = 15;
        boolean isAutorizadoComprarBebida = idade >= 18;
        if (isAutorizadoComprarBebida) {
            System.out.println("Autorizado a comprar bebida alcoólica.");
        } else {
            System.out.println("Não autorizado a comprar bebida acoólica.");
        }
        // !
        if (!isAutorizadoComprarBebida) {
            System.out.println("Não autorizado a comprar bebida acoólica.");
        }
    }
}
