package model.service;

import model.dao.DeveloperDAO;
import model.entity.Developer;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeveloperService {
    public ArrayList<Developer> getDevelopers() throws SQLException {
        DeveloperDAO developerDAO = new DeveloperDAO();
        ArrayList<Developer> developers = developerDAO.getDevelopers();
        developerDAO.close();
        return developers;
    }
}
