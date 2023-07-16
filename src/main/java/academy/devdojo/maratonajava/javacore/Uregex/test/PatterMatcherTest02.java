package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest02 {
    public static void main(String[] args) {
        // \d = retorna todos os digitos
        // \D = retorna tudo o que não for digito
        // \s = retona todos os espaços em branco, \t \n \f \r
        // \S = retona todos os caracteres excluindo os branco
        // \w = retona tudo de a-z, A-Z, digitos, _
        // \W = retona tudo o que não for incluso no \w
        String regex = "\\W";
        String texto = "abaaba";
        String texto2 = "@uw_eygd  yteg\tdtfw4552";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("Texto:  " + texto2);
        System.out.println("índice: 0123456789");
        System.out.println("Regex: " + regex);
        System.out.println("Posições encontradas: ");
        while(matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
