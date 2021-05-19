package config;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseManager {

    public static Connection getH2DataSource() throws SQLException {
        //config ca sa va conectati la H2Database
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:file:./db/store");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        return dataSource.getConnection();
    }

    public static Connection getPostgreSqlDataSourceConnection() throws SQLException {
        //config ca sa va conectati la Postgre
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");

    }

    public static Connection getPostgreSqlConnection(String url, String user, String password) throws SQLException {

        Properties props = new Properties();
        props.setProperty("user",user);
        props.setProperty("password", password);

        return DriverManager.getConnection(url, props);
    }
}
