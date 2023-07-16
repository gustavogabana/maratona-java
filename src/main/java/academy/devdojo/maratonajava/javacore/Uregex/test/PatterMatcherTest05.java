package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatterMatcherTest05 {
    public static void main(String[] args) {
        // \d = retorna todos os digitos
        // \D = retorna tudo o que não for digito
        // \s = retona todos os espaços em branco, \t \n \f \r
        // \S = retona todos os caracteres excluindo os branco
        // \w = retona tudo de a-z, A-Z, digitos, _
        // \W = retona tudo o que não for incluso no \w
        // [] = range
        // Quantificadores: ? = retorna 0 ou 1 ocorrência
        // * = retorna 0 ou mais ocorrência
        // + = retona 1 ou mais ocorrência
        // {n, m} = retorna de n até m
        // () e | = o(v|c)o retorna o agrupamento de ovo ou oco
        // $ = retorna o fim da linha
        // . = 123, 133, 1@3, 1A3
        // ^ = retorna o match da posição do primeiro caracter

        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String texto = "luffy@hotmail.com, 123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail ";
        System.out.println("E-mail válido:");
        System.out.println("#@!zoro@mail.br".matches(regex));
        System.out.println("Array de e-mails: " + Arrays.toString(texto.split(",")));
        System.out.println("E-mail sem espaços: " + texto.split(",")[1].trim());
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  " + texto);
        System.out.println("índice: 0123456789");
        System.out.println("Regex: " + regex);
        System.out.println("Posições encontradas: ");
        while (matcher.find()) {
            System.out.print(matcher.start() + " " + matcher.group() + "\n");
        }
    }
}
