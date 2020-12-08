package model.dao;

import model.entity.Developer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeveloperDAO extends BaseDAO {
    public DeveloperDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }
    public ArrayList<Developer> getDevelopers(){
        String findDevelopers = "select * from developers";
        ArrayList<Developer> developers = new ArrayList<>();

            try (ResultSet resultSet = connection.createStatement().executeQuery(findDevelopers)) {
                while (resultSet.next()) {
                    developers.add(new Developer(
                            resultSet.getString("name"),
                            resultSet.getString("image")
                    ));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return developers;
    }
}
