package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasicConnectionPool implements ConnectionPool {

    private String url;
    private String user;
    private String password;

    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();

    private static final int INITIAL_POOL_SIZE = 10;

    private BasicConnectionPool(String url, String user, String password, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    public static BasicConnectionPool create(String url, String user, String password) throws SQLException {
        // pragatesc lista de connexiuni deschisa la db
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
//        adaug numarul de conexiuni deschise in cazul de fata 10
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(DataBaseManager.getPostgreSqlConnection(url, user, password));
        }

        return new BasicConnectionPool(url, user, password, pool);
    }

    @Override
    public Connection getConnection() {
        //prin metoda asta eu voi lua conexiuni pe care mai apoi le voi folosi ca sa execut query-uri la db

        //scot in element din connectionPool si il introduc in used connection list
        Connection connection = connectionPool
                .remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        //folosit pentru eliberarea conexiunii
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
