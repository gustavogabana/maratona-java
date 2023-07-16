package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.listener.CustomRowSetListener;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.model.Producer;
import lombok.extern.log4j.Log4j2;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepositoryRowSet {

    public static List<Producer> findByNameJdbcRowSet(String name) {

        String sql = "select * from anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {

            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql); // serve para montar o sql
            jrs.setString(1, String.format("%%%s%%", name));
            jrs.execute(); // serve apenas para buscar dados

            while (jrs.next()) {
                Producer producer = new Producer(jrs.getInt("id"), jrs.getString("name"));
                producers.add(producer);
            }

        } catch (SQLException e) {
            log.info("Error while trying to find producers.", e);
        }

        return producers;
    }

    public static void updateJdbcRowSet(Producer producer) { // este RowSet é conectado ao banco
        String sql = "select * from anime_store.producer where (`id` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {

            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql); // serve para montar o sql
            jrs.setInt(1, producer.getId());
            jrs.execute();
            if (!jrs.next()) return;
            jrs.updateString("name", producer.getName());
            jrs.updateRow();

        } catch (SQLException e) {
            log.info("Error while trying to find producers.", e);
        }
    }

    public static void updateCachedRowSet(Producer producer) { // este RowSet é conectado ao banco
        String sql = "select * from producer where (`id` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getJdbcCachedRowSet();
             Connection connection = ConnectionFactory.getConnection()) {

            connection.setAutoCommit(false); // serve para evitar o conflito entre o autocommit=true do drive do mysql
            // com o commit feito pelo acceptChanges() do CachedRowSet

//            crs.addRowSetListener(new CustomRowSetListener());
            crs.setCommand(sql); // serve para montar o sql
            crs.setInt(1, producer.getId());
            crs.execute(connection); // serve para executar a conexão com a config customizada
            if (!crs.next()) return;
            crs.updateString("name", producer.getName());
            crs.updateRow();
            crs.acceptChanges(); // aceita as mudanças feitas para enviar de volta ao banco

        } catch (SQLException e) {
            log.info("Error while trying to find producers.", e);
        }
    }

}
