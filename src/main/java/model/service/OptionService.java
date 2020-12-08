package model.service;

import model.dao.OptionDAO;
import model.entity.Option;

import java.sql.SQLException;
import java.util.ArrayList;

public class OptionService {
    public ArrayList<Option> getOptions() throws SQLException {
        OptionDAO optionDAO = new OptionDAO();
        ArrayList<Option> options= optionDAO.getOptionNames();
        optionDAO.close();
        return options;
    }
}
