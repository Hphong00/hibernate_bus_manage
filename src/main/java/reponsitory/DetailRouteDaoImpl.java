package reponsitory;

import entity.Assignment;
import entity.detail.DetailRoute;
import org.hibernate.Session;
import org.hibernate.query.Query;
import reponsitory.dao.Dao;
import util.HibernateUtil;

import java.util.List;

public class DetailRouteDaoImpl implements Dao<DetailRoute> {

    @Override
    public List<DetailRoute> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            String sql = "Select dr from DetailRoute dr";
            Query<DetailRoute> query = session.createQuery(sql);
            List<DetailRoute> detailRoutes = query.getResultList();
            for (DetailRoute detailRoute : detailRoutes) {
                System.out.println(detailRoute.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public DetailRoute geEntityById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            DetailRoute detailRoute = session.load(DetailRoute.class, id);
            session.getTransaction().commit();
            System.out.println(detailRoute.toString());
            return detailRoute;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean add(DetailRoute detailRoute) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(detailRoute);
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
    public boolean update(DetailRoute detailRoute) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(detailRoute);
            session.getTransaction().commit();
            System.out.println("update succsessfull");
            return true;
        } catch (Exception e) {
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
            DetailRoute detailRoute = session.load(DetailRoute.class, id);
            session.delete(detailRoute);
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
