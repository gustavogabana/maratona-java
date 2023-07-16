package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest03 {
    public static void main(String[] args) {
        // \d = retorna todos os digitos
        // \D = retorna tudo o que não for digito
        // \s = retona todos os espaços em branco, \t \n \f \r
        // \S = retona todos os caracteres excluindo os branco
        // \w = retona tudo de a-z, A-Z, digitos, _
        // \W = retona tudo o que não for incluso no \w
        // []
        // String regex = "[a-zA-Z]";
        String regex = "0[xX][0-9a-fA-F]";
        // String texto = "aba";
        String texto2 = "12 0x 0X 0xFFABC 0x109 0x1";
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
