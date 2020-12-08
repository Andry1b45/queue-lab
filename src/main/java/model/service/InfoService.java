package model.service;

import model.dao.InfoDAO;
import model.entity.Info;
import model.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class InfoService {
    public ArrayList<Info> getInfo(Student student) throws SQLException {
        InfoDAO infoDAO = new InfoDAO();
        ArrayList<Info> infoArrayList = infoDAO.getInfo(Integer.parseInt(student.getGroup()));
        infoDAO.close();
        return infoArrayList;
    }

}
