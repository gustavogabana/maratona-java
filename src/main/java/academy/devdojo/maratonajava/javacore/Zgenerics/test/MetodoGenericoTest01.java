package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Ycolecoes.model.Manga;
import academy.devdojo.maratonajava.javacore.Zgenerics.model.Carro;

import java.util.ArrayList;
import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {
        List<Manga> objects = criarArrayComObjeto(new Manga(123L, "Nome", 0.99));
    }

    // método genérico que aceita apenas classes que implementam Comparable, por exemplo.
    private static <T extends Comparable> List<T> criarArrayComObjeto(T t) {
        List<T> list = List.of(t);
        return list;
    }
}

class DoisAtributos<T,X,I> {
    private T t;
    private X x;
    private I i;

    public DoisAtributos(T t, X x, I i) {
        this.t = t;
        this.x = x;
        this.i = i;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public X getX() {
        return x;
    }

    public void setX(X x) {
        this.x = x;
    }

    public I getI() {
        return i;
    }

    public void setI(I i) {
        this.i = i;
    }
}
