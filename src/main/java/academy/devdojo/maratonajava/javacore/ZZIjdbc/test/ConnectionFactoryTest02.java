package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.model.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerServiceRowSet;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
//        List<Producer> producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
//        log.info("Producers found '{}'.", producers);

        ProducerServiceRowSet.updateCachedRowSet(new Producer(1, "MADHOUSE"));

//        producers = ProducerServiceRowSet.findByNameJdbcRowSet("");
//        log.info("Producers found '{}'.", producers);
    }
}
