package academy.devdojo.maratonajava.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();
        nomes.add("William");
        nomes.add("DevDojo");
        nomes2.add("Suane");
        nomes2.add("Academy");
        //nomes.remove(1);
        //System.out.println(nomes.remove("william")); // Remove o objeto através do equals do objeto.

        nomes.addAll(nomes2);

        for (String nome : nomes) {
            System.out.println(nome);
        }
        System.out.println("-------------");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
    }
}
