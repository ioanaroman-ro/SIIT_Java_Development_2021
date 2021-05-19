package siit.db;

import dao.CustomerDao;
import model.Customer;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DbMain {

    public static void main(String[] args) {

        try (
                Connection connection = getPostgreSqlDataSourceConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery("select * from customers")
        ) {

            while (rs.next()) {
                System.out.println("Customer { " + rs.getInt("id") + ", " + rs.getString("name") + " }");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static DataSource getH2DataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:file:./db/store");
        dataSource.setUser("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    public static Connection getPostgreSqlDataSourceConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "123456");

    }

}
