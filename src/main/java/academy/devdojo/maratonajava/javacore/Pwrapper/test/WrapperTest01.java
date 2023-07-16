package academy.devdojo.maratonajava.javacore.Pwrapper.test;

public class WrapperTest01 {
    public static void main(String[] x) {
        // Tipos primitivos
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 10;
        // Ou = 10L; long primitivo, o L ou l é facultativo
        float floatP = 10.0f;
        // Sem o pós-fixo f, 10.0 seria double, e não poderia ser declarado em uma variavél do tipo float
        double doubleP = 10.0;
        char charP = 'A';
        boolean booleanP = false;

        // Wrappers
        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1; // autoboxing
        Long longW = 10L;
        Float floatW = 10F;
        Double doubleW = 10D;
        Character charW = 'A';
        Boolean booleanW = false;

        int i = intW; // unboxing
        Integer intW2 = Integer.parseInt("1");
        boolean verdadeiro = Boolean.parseBoolean("true");
        System.out.println(verdadeiro);

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('!'));
    }
}
