package DAO_Controller;

import DAO.DAO;
import model.Fahrzeug;

import java.sql.SQLException;
import java.util.List;

public class F_fahrzeuge implements DAO<Fahrzeug> {
    @Override
    public void save(Fahrzeug fahrzeug) throws SQLException {

    }

    @Override
    public void update(Fahrzeug fahrzeug) throws SQLException {

    }

    @Override
    public Fahrzeug getById(int id) throws SQLException {
        return null;
    }

    @Override
    public void delete(Fahrzeug fahrzeug) throws SQLException {

    }

    @Override
    public List<Fahrzeug> getAll() throws SQLException {
        return null;
    }
}
