package reponsitory;

import entity.Assignment;
import entity.Driver;
import org.hibernate.Session;
import org.hibernate.query.Query;
import reponsitory.dao.Dao;
import util.HibernateUtil;

import java.util.List;

public class AssignmentDaoImpl implements Dao<Assignment> {
    @Override
    public List<Assignment> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            String sql = "Select a from Assignment a";
            Query<Assignment> query = session.createQuery(sql);
            List<Assignment> assignments = query.getResultList();
            for (Assignment assignment : assignments) {
                System.out.println(assignment.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Assignment geEntityById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            Assignment assignment = session.load(Assignment.class, id);
            session.getTransaction().commit();
            System.out.println(assignment.toString());
            return assignment;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public boolean add(Assignment assignment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(assignment);
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
    public boolean update(Assignment assignment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(assignment);
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
            Assignment assignment = session.load(Assignment.class, id);
            session.delete(assignment);
            session.getTransaction().commit();
            System.out.println("delete succsessfull");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }
    public List<Assignment> sortAsignmentName() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            String sql = "Select A from Assignment A order by A.driverFullname,A.id ";
            Query<Assignment> query = session.createQuery(sql);
            List<Assignment> assignments = query.getResultList();
            for (Assignment assignment : assignments) {
                System.out.println(assignment.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
    public List<Assignment> sortAsignmentNumber() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            String sql = "Select A from Assignment A order by A.driverFullname ";
            Query<Assignment> query = session.createQuery(sql);
            List<Assignment> assignments = query.getResultList();
            for (Assignment assignment : assignments) {
                System.out.println(assignment.toString());
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return null;
    }
}
