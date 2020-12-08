package model.service;

import model.dao.*;
import model.entity.Option;
import model.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentService {
    public Student getStudentById(String id) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudentByID(id);
        studentDAO.close();
        return student;
    }
}
