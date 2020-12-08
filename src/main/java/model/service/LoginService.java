package model.service;

import model.dao.StudentDAO;
import model.entity.Student;

import java.sql.SQLException;

public class LoginService {

    public String login() {
        StudentDAO dao = null;
        try {
            dao = new StudentDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Student student = dao.findStudent("Анастасія", "Лапа", "is8113");

        if (student == null) {
            System.out.println("No such user");
        } else {
            try {
                dao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "Welcome, " + student.getName();
        }
        System.out.println(student);
        return "";
    }
}
