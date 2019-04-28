package DAO_Controller;

import DAO.DAO;
import HibernateUtil.SessionUtil;
import model.Fahrlehrer;
import model.Fahrschüler;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class F_lehrer implements DAO<Fahrlehrer> {
    @Override
    public void save(Fahrlehrer fahrlehrer) throws SQLException {
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            session.beginTransaction();
            session.save(fahrlehrer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void update(Fahrlehrer fahrlehrer) throws SQLException {
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            session.beginTransaction();
            session.update(fahrlehrer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Fahrlehrer getById(int id) throws SQLException {
        Fahrlehrer fahrlehrer = null;
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            fahrlehrer = session.load(Fahrlehrer.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return fahrlehrer;
    }

    @Override
    public void delete(Fahrlehrer fahrlehrer) throws SQLException {
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            session.beginTransaction();
            session.delete(fahrlehrer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }

    }

    @Override
    public List<Fahrlehrer> getAll() throws SQLException {
        List<Fahrlehrer> fahrschülerList = null;
        Session session = null;
        try {
            session = new SessionUtil().openSession();
            fahrschülerList = session.createCriteria(Fahrlehrer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) session.close();
        }
        return fahrschülerList;
    }
}
