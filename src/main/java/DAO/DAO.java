package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public void save(T t) throws SQLException;

    public void update(T t) throws SQLException;

    public T getById(int id) throws SQLException;

    public void delete(T t) throws SQLException;

    public List<T> getAll() throws SQLException;

;

}