package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.model.Funcionario;

public class HerancaTest02 {
    public static void main(String[] args) {
        // Bloco de inicialização de instância: executa toda vez que o objeto é instânciado
        // Bloco de inicialização de instância da superclasse é criado
        // Ordem:
        // 0 - Tudo o que é static é criado
        // 1 - Alocado espaço em memória para o objeto
        // 2 - Cada atributo de classe é criado e inicializado com valores default ou o que for passado
        // 3 - Bloco de inicialização é executado
        // 4 - Construtor é executado
        Funcionario funcionario = new Funcionario("Jiraya");
    }
}
