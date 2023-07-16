package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.model.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {

    public static void saveTransaction(List<Producer> producers) {
        try (Connection conn = ConnectionFactory.getConnection()) {
            conn.setAutoCommit(false); // desativa auto commit para não salvar nada se algum der exceção
            preparedStatementSaveTransaction(conn, producers);
            conn.commit(); // serve para comitar manualmente
            conn.setAutoCommit(true); // voltar para true, por conexão
        } catch (SQLException e) {
            log.error("Error while trying to save producers '{}'", producers);
            e.printStackTrace();
        }
    }

    private static void preparedStatementSaveTransaction(Connection conn, List<Producer> producers) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES (?);";
        boolean rollback = false; // var de controle para rollback
        for (Producer producer : producers) {
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                log.info("Saving producer '{}.'", producer.getName());
                ps.setString(1, producer.getName());
                //if (producer.getName().equals("White Fox")) throw new SQLException("Can't save white fox!");
                ps.execute();
            } catch (SQLException e) {
                log.error("Error while trying to inser data into the database.", e);
                rollback = true;
                break;
            }
        }
        if (rollback) {
            log.warn("Transaction is going to be rolledback!");
            conn.rollback(); // rollback em tudo caso seja lançada exeção
        }
    }

    public static void save(Producer producer) {
        String sql = "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');".formatted(producer.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) { // statement para inserir no banco de dados

            int rowsAffected = stmt.executeUpdate(sql);// Utilizado para inserir no database
            log.info("Inserted producer '{}', rows affected: {}.", producer.getName(), rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to insert producer '{}'.", producer.getName());
            e.printStackTrace();
        }
    }

    public static void delete(Integer id) {
        String sql = "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}', rows affected: '{}'.", id, rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to delete producer '{}'.", id);
            e.printStackTrace();
        }
    }

    public static void update(Producer producer) {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');"
                .formatted(producer.getName(), producer.getId());

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {

            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Updated producer '{}', rows affected: '{}'.", producer.getId(), rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId());
            e.printStackTrace();
        }
    }

    public static List<Producer> findAll() {
        log.info("Finding all producers.");
        return findByName("");
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding producers by name.");
        String sql = "select id, name from producer where name like '%s';".formatted("%" + name + "%");
        List<Producer> list = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { // ResultSet serve para buscar dados do banco

            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("name");

                list.add(new Producer(id, name));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.");
            e.printStackTrace();
        }
        return list;
    }

    public static void showProducerMetaData() {
        log.info("Showing Producer Metadata.");
        String sql = "select * from producer;";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) { // ResultSet serve para buscar dados do banco

            ResultSetMetaData metaData = rs.getMetaData(); // ResultSetMetaData serve para obter metadados
            rs.next(); // Para mover o cursos uma linha e apontar para o 1º registro

            int columnCount = metaData.getColumnCount();
            log.info("Columns count: '{}'.", columnCount);

            for (int i = 1; i <= columnCount; i++) {
                log.info("Table name: '{}'.", metaData.getTableName(i));
                log.info("Column name: '{}'.", metaData.getColumnName(i));
                log.info("Column size: '{}'.", metaData.getColumnDisplaySize(i));
                log.info("Column type: '{}'.", metaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.");
            e.printStackTrace();
        }
    }

    public static void showDriverMetaData() {
        log.info("Showing Driver Metadata.");

        try (Connection conn = ConnectionFactory.getConnection()) { // ResultSet serve para buscar dados do banco
            DatabaseMetaData metaData = conn.getMetaData();
            // verificação de movimentação do cursor
            if (metaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Supports TYPE_FORWARD_ONLY");
                // verificação se suporta alterar os dados enquando navega pelas linhas
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE");
                }
            }
            // verifica se o scroll é insensitive, isto é, não altera os dados em tempo real
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Supports TYPE_SCROLL_INSENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE");
                }
            }
            // verifica se o scroll é sensitive, isto é, altera os dados em tempo real enquanto navega
            if (metaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Supports TYPE_SCROLL_SENSITIVE");
                if (metaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.info("And supports CONCUR_UPDATABLE");
                }
            }
        } catch (SQLException e) {
            log.error("Error while trying to find all producers.", e);
        }
    }

    public static void showTypeScrollWorking() {
        String sql = "select * from producer;";

        try (Connection conn = ConnectionFactory.getConnection();
             // informar o tipo do scroll e concorrência suportados pelo drive
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) { // ResultSet serve para buscar dados do banco

            log.info("Last row: '{}'", rs.last()); // vai para última linha
            log.info("Row: '{}'", rs.getRow()); // retorna o nº da linha
            log.info(new Producer(rs.getInt("id"), rs.getString("name")));

            log.info("First row: '{}'", rs.first()); // vai para primeira linha
            log.info("Row: '{}'", rs.getRow()); // retorna o nº da linha
            log.info(new Producer(rs.getInt("id"), rs.getString("name")));

            log.info("Row absolute: '{}'", rs.absolute(2)); // vai para linha informada
            log.info("Row: '{}'", rs.getRow()); // retorna o nº da linha
            log.info(new Producer(rs.getInt("id"), rs.getString("name")));

            log.info("Row relative: '{}'", rs.relative(-1)); // vai para linha informada relativamente à linha atual
            log.info("Row: '{}'", rs.getRow()); // retorna o nº da linha
            log.info(new Producer(rs.getInt("id"), rs.getString("name")));

            log.info("Is last: '{}'", rs.isLast()); // verifica se a linha atual é a última
            log.info("Is after last: '{}'", rs.isAfterLast()); // verifica se a linha atual é depois da última
            log.info("Is first: '{}'", rs.isFirst()); // verifica se a linha atual é a primeira
            log.info("Is before first: '{}'", rs.isBeforeFirst()); // verifica se a linha atual é antes da primeira
            log.info("Row: '{}'", rs.getRow()); // retorna o nº da linha
            log.info(new Producer(rs.getInt("id"), rs.getString("name")));

            log.info("----------------------------------");
            log.info("Last row: '{}'", rs.last()); // vai para última linha
            rs.next();
            log.info("Is after last: '{}'", rs.isAfterLast()); // verifica se a linha atual é depois da última
            while (rs.previous()) { // move o cursor para a linha anterior
                log.info(new Producer(rs.getInt("id"), rs.getString("name")));
            }

        } catch (SQLException e) {
            log.error("Error while trying to scroll.", e);
        }
    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.info("Finding producers by name.");
        String sql = "select id, name from producer where name like '%s';".formatted("%" + name + "%");
        List<Producer> list = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) { // ResultSet serve para buscar dados do banco, coloca dentro da memória

            while (rs.next()) {

                rs.updateString("name", rs.getString("name").toUpperCase());
                rs.updateRow(); // serve para executar o update da informação que está em memória
                // utilize rs.cancelRowUpdates(); para rollback, somente antes do update

                int id = rs.getInt("id");
                name = rs.getString("name");

                list.add(new Producer(id, name));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.");
            e.printStackTrace();
        }
        return list;
    }

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        log.info("Finding producers by name.");
        String sql = "select id, name from producer where name like '%s';".formatted("%" + name + "%");
        List<Producer> list = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) { // ResultSet serve para buscar dados do banco, coloca dentro da memória

            if (rs.next()) return list;

            insertNewProducer(name, rs);
            list.add(getProducer(rs));

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.");
            e.printStackTrace();
        }
        return list;
    }

    public static void findByNameAndDelete(String name) {
        log.info("Finding producers by name.");
        String sql = "select id, name from producer where name like '%s';".formatted("%" + name + "%");

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) { // ResultSet serve para buscar dados do banco, coloca dentro da memória

            while (rs.next()) {
                log.info("Deleting '{}.'", rs.getString("name"));
                rs.deleteRow(); // deleta a linha em memória
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.", e);
        }
    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        rs.moveToInsertRow(); // move para uma linha temporaria
        rs.updateString("name", name);
        rs.insertRow(); // serve para inserir de fato
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        rs.beforeFirst(); // volta para o inicio
        rs.next();
        int id = rs.getInt("id");
        String name = rs.getString("name");

        return new Producer(id, name);
    }

    public static List<Producer> findByNamePreparedStatement(String name) {
        log.info("Finding producers by name.");
        List<Producer> list = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = preparedStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) { // SQL pré-compilado

            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("name");

                list.add(new Producer(id, name));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.");
            e.printStackTrace();
        }
        return list;
    }

    public static void updatePreparedStatement(Producer producer) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement pr = preparedStatementUpdate(conn, producer)) {

            int rowsAffected = pr.executeUpdate();
            log.info("Updated producer '{}', rows affected: '{}'.", producer.getId(), rowsAffected);

        } catch (SQLException e) {
            log.error("Error while trying to update producer '{}'", producer.getId());
            e.printStackTrace();
        }
    }

    private static PreparedStatement preparedStatementUpdate(Connection conn, Producer producer) throws SQLException {
        String sql = "UPDATE `anime_store`.`producer` SET `name` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, producer.getName());
        ps.setInt(2, producer.getId());

        return ps;
    }

    private static PreparedStatement preparedStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "select id, name from producer where name like ?;"; //wildcard
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, "%" + name + "%");

        return preparedStatement;
    }

    public static List<Producer> findByNameCallableStatement(String name) {
        log.info("Finding producers by name.");
        List<Producer> list = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             CallableStatement cs = callableStatementFindByName(conn, name);
             ResultSet rs = cs.executeQuery()) { // SQL pré-compilado

            while (rs.next()) {
                int id = rs.getInt("id");
                name = rs.getString("name");

                list.add(new Producer(id, name));
            }

        } catch (SQLException e) {
            log.error("Error while trying to find all producers.");
            e.printStackTrace();
        }
        return list;
    }

    private static CallableStatement callableStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = "CALL `anime_store`.`sp_get_producer_by_name`(?);";
        CallableStatement callableStatement = conn.prepareCall(sql);
        callableStatement.setString(1, "%" + name + "%");

        return callableStatement;
    }

}
