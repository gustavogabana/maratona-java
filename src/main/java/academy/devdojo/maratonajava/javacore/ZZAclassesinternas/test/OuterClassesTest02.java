package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest02 {

    private String name = "Mydoria";

    void print() {
        String lastName = "Izuku";
        // Variavéis e parâmetros tem de ser efetivamente final porque a classe local pode estar em memória
        class LocalClass {
            public void printLocal() {
                System.out.println(name + lastName);
            }
        }
        LocalClass localClass = new LocalClass();
        localClass.printLocal();
    }

    public static void main(String[] args) {
        OuterClassesTest02 outer = new OuterClassesTest02();
        outer.print();
    }
}
