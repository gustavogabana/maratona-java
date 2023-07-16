package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.model.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.Optional;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
        Producer producer = new Producer(null, "Studio Deen");

        //ProducerService.save(producer);

        //ProducerService.delete(4);

        //ProducerService.update(new Producer(1, "MADHOUSE"));

        //log.info(ProducerService.findAll());

        //log.info(ProducerService.findByName("madhouse"));

        //ProducerService.showProducerMetaData();

        //ProducerService.showDriverMetaData();

        //ProducerService.showTypeScrollWorking();

        //List<Producer> producers = ProducerService.findByNameAndUpdateToUpperCase("Studio Deen");

//        List<Producer> producers = ProducerService.findByNameAndInsertWhenNotFound("A-1 Pictures");
//        log.info("Producers found '{}.'", producers);

        //ProducerService.findByNameAndDelete("A-1");

//        List<Producer> producers = ProducerService.findByNamePreparedStatement("b");
//        log.info("Producers found '{}'.", producers);

//        ProducerService.updatePreparedStatement(new Producer(1, "MadHouse"));


        //---------------------Callable Statement executa procedures e functions------------------------

//        List<Producer> producers = ProducerService.findByNameCallableStatement("MadHouse");
//        log.info("Producers found by callable statement: '{}'.", producers);

//        ----------------------------------tipos de logs do log4j2 --------------------------------
//        log.info("INFO");
//        log.debug("DEBUG");
//        log.warn("WARN");
//        log.error("ERROR");
//        log.trace("TRACE");
    }
}
