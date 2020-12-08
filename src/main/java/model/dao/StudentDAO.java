package model.dao;

import model.entity.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO extends BaseDAO {


    public StudentDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }
    public Student findStudent(String name,String surname,String password){
        String findStudent="select student_id, g.name as groupName, s.name as stName,s.surname,s.password " +
                " from students s inner join groups g on g.group_id = s.group_id where s.name = ? and s.surname = ?" +
                " and s.password = ?";
        Student student = null;
        try (PreparedStatement ps = connection.prepareStatement(findStudent)) {
            ps.setString(1, name);
            ps.setString(2,surname);
            ps.setString(3,password);
            try(ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    student = new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getString("groupName"),
                            resultSet.getString("stName"),
                            resultSet.getString("surname"),
                            resultSet.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


    public Student getStudentByID(String id) {
        Student student = null;
        id = id.substring(1);
        String findStudentByID = "select  * from students where student_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(findStudentByID)) {
            ps.setInt(1, Integer.parseInt(id));
            try(ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    student = new Student(
                            resultSet.getInt("student_id"),
                            resultSet.getString("group_id"),
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
