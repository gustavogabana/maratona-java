package academy.devdojo.maratonajava.javacore.Kenum.test;

import academy.devdojo.maratonajava.javacore.Kenum.model.Cliente;
import academy.devdojo.maratonajava.javacore.Kenum.model.TipoCliente;
import academy.devdojo.maratonajava.javacore.Kenum.model.TipoPagamento;

public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Tsubasa", TipoCliente.PESSOA_FISICA, TipoPagamento.DEBITO);
        Cliente cliente2 = new Cliente("Akira", TipoCliente.PESSOA_JURIDICA, TipoPagamento.CREDITO);

        System.out.println(cliente1);
        System.out.println(cliente2);

        System.out.println(TipoPagamento.DEBITO.calcularDesconto(100));
        System.out.println(TipoPagamento.CREDITO.calcularDesconto(100));

        TipoCliente tipoCliente = TipoCliente.valueOf("Pessoa Física");
        System.out.println(tipoCliente);

        TipoCliente tipoCliente2 = TipoCliente.tipoClientePorNomeRelatorio("Pessoa Jurídica");
        System.out.println(tipoCliente2);


    }
}
