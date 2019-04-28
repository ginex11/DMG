package DAO_Controller;

import DAO.DAO;
import HibernateUtil.SessionUtil;
import model.Fahrschüler;
import org.hibernate.Session;
import java.sql.SQLException;
import java.util.List;

public class F_schüler implements DAO<Fahrschüler> {

    @Override
    public void save(Fahrschüler fahrschüler) throws SQLException {
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            session.beginTransaction();
            session.save(fahrschüler);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void update(Fahrschüler fahrschüler) throws SQLException {
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            session.beginTransaction();
            session.update(fahrschüler);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Fahrschüler getById(int id) throws SQLException {
        Fahrschüler fahrschüler = null;
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            fahrschüler = session.load(Fahrschüler.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return fahrschüler;
    }

    @Override
    public void delete(Fahrschüler fahrschüler) throws SQLException {
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            session.beginTransaction();
            session.delete(fahrschüler);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }

    }

    @Override
    public List<Fahrschüler> getAll() throws SQLException {
        List<Fahrschüler> fahrschülerList = null;
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            fahrschülerList = session.createCriteria(Fahrschüler.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return fahrschülerList;
    }
}
