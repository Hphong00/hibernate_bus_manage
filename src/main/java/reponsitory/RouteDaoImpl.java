package reponsitory;

import entity.Route;
import org.hibernate.Session;
import org.hibernate.query.Query;
import reponsitory.dao.Dao;
import util.HibernateUtil;

import java.util.List;

public class RouteDaoImpl implements Dao<Route> {
    @Override
    public List<Route> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            String sql = "Select r from Route r";
            Query<Route> query = session.createQuery(sql);
            List<Route> routes = query.getResultList();
            for (Route route : routes) {
                System.out.println(routes.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Route geEntityById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            Route route = session.load(Route.class, id);
            session.getTransaction().commit();
            System.out.println(route.toString());
            return route;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean add(Route route) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(route);
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
    public boolean update(Route route) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(route);
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
            Route route = session.load(Route.class, id);
            session.delete(route);
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
