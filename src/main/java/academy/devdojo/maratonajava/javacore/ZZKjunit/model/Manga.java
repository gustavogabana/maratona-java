package academy.devdojo.maratonajava.javacore.ZZKjunit.model;

import java.util.Objects;

public record Manga(String name, int episodes) {
    // record é um novo tipo de blueprint imutável
    // não é permitido criar atributos de instância diretamente, apenas estaticos
    // records aceitam generics

    // compact constructor:
    public Manga {
        Objects.requireNonNull(name);
    }

    // records podem ser privados quando são inner classes de outras classes
}
