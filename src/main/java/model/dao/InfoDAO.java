package model.dao;


import model.entity.Info;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoDAO extends BaseDAO {
    public InfoDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }

    public ArrayList<Info> getInfo(int group_id) throws SQLException {
        String findInfo = "select name, href, svg from info where group_id = ?";
        ArrayList<Info> infoArrayList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(findInfo)) {
            ps.setInt(1, group_id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    infoArrayList.add(new Info(
                            resultSet.getString("name"),
                            resultSet.getString("href"),
                            resultSet.getString("svg"))
                    );
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return infoArrayList;
    }
}