package model.dao;

import model.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class BaseDAO{
    protected ConnectionPool connectionPool = ConnectionPool.getConnectionPool();
    protected Connection connection;

    public void close() throws SQLException {
        connection.close();
    }
}
