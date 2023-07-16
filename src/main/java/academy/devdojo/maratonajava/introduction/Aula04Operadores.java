package academy.devdojo.maratonajava.introduction;

public class Aula04Operadores {
    public static void main(String[] args) {
        // + - / *
        int numero01 = 10;
        int numero02 = 20;
        System.out.println(numero02 + numero01);

        // %
        int resto = 20 % 2;
        System.out.println(resto);

        // < > <= >= == !=
        boolean isDezMaiorQueVinte = false;
        boolean isDezMenorQueVinte = true;
        boolean isDezIgualVinte = false;
        boolean isDezDiferenteQueVinte = true;

        System.out.println("isDezMaiorQueVinte " + isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte " + isDezMenorQueVinte);
        System.out.println("isDezIgualVinte " + isDezIgualVinte);
        System.out.println("isDezDiferenteQueVinte " + isDezDiferenteQueVinte);

        // && (AND) || (OR) !(NOT)
        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario > 4612;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 3381;
        System.out.println("isDentroDaLeiMaiorQueTrinta " + isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta " + isDentroDaLeiMenorQueTrinta);

        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupanca = 10000;
        float valorPlaystation = 5000F;
        boolean isPlaysationCincoCompravel = valorTotalContaCorrente > valorPlaystation || valorTotalContaPoupanca > valorPlaystation;
        System.out.println("isDentroDaLeiMenorQueTrinta " + isPlaysationCincoCompravel);

        // = += -= *= /= %=
        double bonus = 1800;
        bonus += 1000; // 2800
        bonus -= 1000; // 1800
        bonus *= 2; // 3600
        bonus /= 2; // 1800
        System.out.println(bonus);

        // ++ --
        int contador = 0;
        contador += 1;
        contador++;
        contador--;
        ++contador;
        --contador;
        int contador2 = 0;
        System.out.println(++contador2);
    }
}
