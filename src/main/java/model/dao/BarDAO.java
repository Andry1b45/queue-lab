package model.dao;

import model.entity.Bar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BarDAO extends BaseDAO{
    public BarDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }

    public ArrayList<Bar> getBars() throws SQLException {
        String findNames = "select * from bars";
        ArrayList<Bar> bars = new ArrayList<>();
            try (ResultSet resultSet = connection.createStatement().executeQuery(findNames)) {
                while (resultSet.next()) {
                    bars.add(new Bar(
                            resultSet.getString("name"),
                            resultSet.getString("href"),
                            resultSet.getString("svg")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
        }
        return bars;
    }
}
