package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest03 {
    private String name;
    static class Nested {
        void print() {
            System.out.println(new OuterClassesTest03().name); // Tem de criar a classe externa pois a classe intera é static
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
