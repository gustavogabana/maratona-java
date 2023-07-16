package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.model.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.model.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class AnimeRepository {

    public static List<Anime> findByName(String name) {
        log.info("Finding animes by name...");
        List<Anime> animes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producer producer = new Producer(rs.getInt("a.producer_id"), rs.getString("p.name"));

                Anime anime = new Anime(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("episodes"),
                        producer);
                animes.add(anime);
            }

        } catch (SQLException e) {
            log.error("Error while trying to find Anime '{}'", name, e);
        }
        return animes;
    }

    private static PreparedStatement createPreparedStatementFindByName(Connection conn, String name) throws SQLException {
        String sql = """
                select a.id, a.name, a.episodes, a.producer_id, p.name from anime_store.anime a inner join anime_store.producer p
                on p.id = a.producer_id
                where a.name like ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));

        return ps;
    }

    public static Anime findById(Integer id) {
        log.info("Finding producers by id...");
        Anime anime = null;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementFindById(conn, id);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.next()) throw new IllegalArgumentException("Id does not exist.");
            Producer producer = new Producer(rs.getInt("a.producer_id"), rs.getString("p.name"));

            anime = new Anime(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("episodes"),
                    producer);

        } catch (SQLException e) {
            log.error("Error while trying to find Anime '{}'", id, e);
        }
        return anime;
    }

    private static PreparedStatement createPreparedStatementFindById(Connection conn, Integer id) throws SQLException {
        String sql = """
                select a.id, a.name, a.episodes, a.producer_id, p.name from anime_store.anime a inner join anime_store.producer p
                on p.id = a.producer_id
                where a.id like ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        return ps;
    }

    public static void save(Anime anime) {
        log.info("Saving Anime '{}'.", anime.getName());
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSave(conn, anime)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Error while trying to save the Anime '{}.'", anime.getName(), e);
        }
    }

    private static PreparedStatement createPreparedStatementSave(Connection conn, Anime anime) throws SQLException {
        String sql = "INSERT INTO `anime_store`.`Anime` (`name`, `episodes`, `producer_id`) VALUES (?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getProducer().getId());

        return ps;
    }

    public static void delete(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementDelete(conn, id)) {
            ps.execute();
            log.info("Deleted anime '{}.'", id);
        } catch (SQLException e) {
            log.error("Error while trying to delete Anime.", e);
        }
    }

    private static PreparedStatement createPreparedStatementDelete(Connection conn, int id) throws SQLException {
        String sql = "delete from anime_store.Anime where id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        return ps;
    }

    public static void update(Anime anime) {
        log.info("Updating anime '{}'.", anime.getId());
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementUpdate(conn, anime)) {

            ps.executeUpdate();

        } catch (SQLException e) {
            log.error("Error while trying to update Anime '{}'.", anime.getId(), e);
        }
    }

    private static PreparedStatement createPreparedStatementUpdate(Connection conn, Anime anime) throws SQLException {
        String sql = "update anime_store.Anime set name = ?, episodes = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getId());

        return ps;
    }

}
