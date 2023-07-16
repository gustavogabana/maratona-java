package academy.devdojo.maratonajava.javacore.ZZAclassesinternas.test;

public class OuterClassesTest01 {
    private String name = "Monkey D. Luffy";

    class Inner {
        // Inner Class possui acesso a todos os atributos e métodos da Outer Class
        public void printOuterClassAttribute() {
            System.out.println(name);
            System.out.println(this); // Se refere a classe que o contextualiza, neste caso, a classe Inner
            System.out.println(OuterClassesTest01.this); // Se refere a classe Outer
        }
    }

    public static void main(String[] args) {
        OuterClassesTest01 outerClass = new OuterClassesTest01();
        Inner inner = outerClass.new Inner();
        Inner inner2 = new OuterClassesTest01().new Inner();
        inner.printOuterClassAttribute();
        inner2.printOuterClassAttribute();
    }
}
