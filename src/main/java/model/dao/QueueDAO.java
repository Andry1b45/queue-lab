package model.dao;

import model.entity.Queue;
import model.entity.Student;
import model.entity.Subject;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueueDAO extends BaseDAO{

    public QueueDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }

    public void deleteAll() {
        String  deleteAll = "delete from queue where student_id>0";
        try (PreparedStatement ps = connection.prepareStatement(deleteAll)) {
            ps.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void create(Queue entity) {
        String insertQueueLine = "insert into queue(subject_id,student_id,date) values(?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(insertQueueLine)) {
            ps.setInt(1, entity.getSubject().getId() );
            ps.setInt(2, entity.getStudent().getId());
            ps.setDate(3, new Date(new java.util.Date().getTime()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Queue getQueue(Student student, Subject subject){
        String getQueueLine = "select s.name,surname,date from queue inner join students s on s.student_id =" +
                " queue.student_id inner join groups g on s.group_id = g.group_id where subject_id in " +
                "(select subject_id from subject where name = ?) and g.group_id in (select g.group_id from " +
                "groups where g.name = (select name from groups where group_id = ?))";
        Queue queue = null;
        try(PreparedStatement ps = connection.prepareStatement(getQueueLine)){
            ps.setString(1, subject.getName());
            ps.setInt(2, Integer.parseInt(student.getGroup()));
            try(ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    queue = new Queue(
                            resultSet.getString("name"),
                            resultSet.getString("surname"),
                            resultSet.getDate("date")
                    );
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return  queue;
    }


    public static void main(String[] args) throws SQLException {
        new QueueDAO().getQueue(new Student("1", "Анастасія", "Лапа",
                "is8113"), new Subject("Групова динаміка і комунікації"));
    }
}
