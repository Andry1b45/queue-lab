package model.service;

import model.dao.QueueDAO;
import model.entity.Queue;
import model.entity.Student;
import model.entity.Subject;

import java.sql.SQLException;

public class QueueService {

    public void joinQueue(Student student, Subject subject){
        try {
            QueueDAO queueDAO = new QueueDAO();
            queueDAO.create(new Queue(subject, student));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Queue getQueue(Student student, Subject subject){
        Queue queue = null;
        try {
            QueueDAO queueDAO = new QueueDAO();
            queue = queueDAO.getQueue(student, subject);
            queueDAO.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queue;
    }
    public void removeQueue(){
        try {
            QueueDAO queueDAO = new QueueDAO();
            queueDAO.deleteAll();
            queueDAO.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
