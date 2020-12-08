package model.service;

import model.dao.BarDAO;
import model.entity.Bar;

import java.sql.SQLException;
import java.util.ArrayList;

public class BarService {
    public ArrayList<Bar> getBars() throws SQLException {
        BarDAO barDAO = new BarDAO();
        ArrayList<Bar> bars = barDAO.getBars();
        barDAO.close();
        return bars;
    }
}
