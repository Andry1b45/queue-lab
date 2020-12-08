package model;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {
    private static volatile HikariDataSource dataSource;
    private static ConnectionPool connectionPool;
    private ConnectionPool(){}

    public static ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPool == null)
                    connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
    }
    private static DataSource getDataSource() {
        if (dataSource == null) {
            synchronized (ConnectionPool.class) {
                if (dataSource == null) {
                    HikariConfig config = new HikariConfig();
                    ResourceBundle resource = ResourceBundle.getBundle("database");
                    config.setJdbcUrl(resource.getString("url"));
                    config.setUsername(resource.getString("user"));
                    config.setPassword(resource.getString("password"));
                    config.addDataSourceProperty("minimumIdle", Integer.parseInt(resource.getString("minIdle")));
                    config.addDataSourceProperty("maximumPoolSize", Integer.parseInt(resource.getString("maxPoolSize")));
                    config.addDataSourceProperty("connectionTimeout", Integer.parseInt(resource.getString("conTimeout")));
                    dataSource = new HikariDataSource(config);
                }
            }
        }
        return dataSource;
    }

    public  Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

}
