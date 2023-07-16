package academy.devdojo.maratonajava.javacore.ZZIjdbc.conn;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //java.sql = Connection, Statement, ResulSet, DriverManager -> Interfaces para connection
    public static Connection getConnection() throws SQLException { // SINGLETON
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    public static JdbcRowSet getJdbcRowSet() throws SQLException { // este RowSet é conectado
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        JdbcRowSet jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet(); // jdbcRowSet é um javabean
        jdbcRowSet.setUrl(url);
        jdbcRowSet.setUsername(username);
        jdbcRowSet.setPassword(password);
        return jdbcRowSet;
    }

    public static CachedRowSet getJdbcCachedRowSet() throws SQLException { // este RowSet trabalha com dados em memória
        String url = "jdbc:mysql://localhost:3306/anime_store";
        String username = "root";
        String password = "root";
        CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
        cachedRowSet.setUrl(url);
        cachedRowSet.setUsername(username);
        cachedRowSet.setPassword(password);
        return cachedRowSet;
    }
}
