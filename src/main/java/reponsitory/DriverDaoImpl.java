package reponsitory;

import entity.Driver;
import org.hibernate.Session;
import org.hibernate.query.Query;
import reponsitory.dao.Dao;
import util.HibernateUtil;

import java.util.List;

public class DriverDaoImpl implements Dao<Driver> {
    @Override
    public List<Driver> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            String sql = "Select d from Driver d";
            Query<Driver> query = session.createQuery(sql);
            List<Driver> drivers = query.getResultList();
            for (Driver driver : drivers) {
                System.out.println(driver.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Driver geEntityById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            Driver driver = session.load(Driver.class, id);
            session.getTransaction().commit();
            System.out.println(driver.toString());
            return driver;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean add(Driver driver) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(driver);
            session.getTransaction().commit();
            System.out.println("add succsessfull");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean update(Driver driver) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(driver);
            session.getTransaction().commit();
            System.out.println("update succsessfull");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            Driver driver = session.load(Driver.class, id);
            session.delete(driver);
            session.getTransaction().commit();
            System.out.println("delete succsessfull");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }
}
