package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Smartphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        // Se as varriavéis do tipo String tiverem exatamente a mesma string, então elas
        // estarão apontando para o mesmo objeto no pool de strings, dentro do heap

        // == verifica se os objetos comparados estão ocupando o mesmo espaço em memória

        // Método .equals compara se os valores dentro das variavéis são iguais

        Smartphone s1 = new Smartphone("1ABC1", "iPhone");
        Smartphone s2 = new Smartphone("1ABC1", "iPhone");
        System.out.println("Referências diferentes: " + s1.equals(s2));

        // Neste caso, a comparaão .equals é falsa porque o objeto referenciado por s1 não é o mesmo objeto referenciado por s2.
        /*
        * s1.equals(s2) -> A variavél s1 faz referência ao mesmo objeto que a variavél s2?
        * Não, s1 e s2 fazem referência à objetos diferentes.
        * */

        s2 = s1;
        System.out.println("Referências iguais (após sobrescrita): " + s1.equals(s2));
    }
}
