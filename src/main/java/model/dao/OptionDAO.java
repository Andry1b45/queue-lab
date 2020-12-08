package model.dao;

import model.entity.Option;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OptionDAO extends BaseDAO {

    public OptionDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }

    public ArrayList<Option> getOptionNames() throws SQLException {
        String findNames = "select name, alt_name from subject";
        ArrayList<Option> options = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(findNames)) {
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    options.add(new Option(resultSet.getString("name"), resultSet.getString("alt_name")));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return options;
    }

}
