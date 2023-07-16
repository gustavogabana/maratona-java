package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.model.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;

import java.util.List;

public class ConnectionFactoryTest03 {
    public static void main(String[] args) {

        // ------------------------------------ Transações----------------------------------
        // atomicidade no banco de dados, ou executa tudo ou não executa nada

        List<Producer> producers = List.of(
                new Producer(null, "Toei Animation"),
                new Producer(null, "White Fox"),
                new Producer(null, "Studio Ghibli"));

        ProducerService.saveTransaction(producers);

    }
}
