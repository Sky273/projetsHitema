package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class AuthentificationDAO implements Serializable{
	private static final long serialVersionUID = -380219334850403852L;

	public  AuthentificationDAO() {
	}
	public void addAuthentification(Authentification auth) {
		System.out.println("debut addAuthentification");
        System.out.println("a");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trns = session.beginTransaction();
        System.out.println("b");
        try {
            System.out.println("c");
            System.out.println("d");
            session.save(auth);
            System.out.println("e");
            trns.commit();
            System.out.println("f");
        } catch (Exception e) {
            System.out.println("g");
            if (trns != null) {
                System.out.println("h - rollback transaction");
                trns.rollback();
                System.out.println("i");
             }
            e.printStackTrace();
        } finally {
            System.out.println("j");
            //session.flush();
            System.out.println("k");
            session.close();
            System.out.println("l");
        }
        System.out.println("fin addAuthentification");
    }
 
    public void deleteAuthentification(int idUser) {
    	System.out.println("deleteAuthentification(" + idUser + ")");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trns = session.beginTransaction();
        System.out.println("A");
        try {
            
        	Authentification auth = new Authentification();
        	System.out.println("B");
        	auth.setIdUser(idUser);
        	System.out.println("C");
            session.delete(auth);
            System.out.println("D");
            trns.commit();
            System.out.println("E");
        } catch (RuntimeException e) {
        	System.out.println("F");
            if (trns != null) {
            	System.out.println("G");
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
        	System.out.println("H");
            //session.flush();
            session.close();
            System.out.println("I");
        }
    }
 
    public void updateAuthentification(Authentification auth) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(auth);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
 
    public List<Authentification> getAllAuthentifications() {
        List<Authentification> authentifications = new ArrayList<Authentification>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            authentifications = session.createQuery("select c from Authentification c").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return authentifications;
    }
 
    public List<Authentification> getAuthentificationByLogin(String loginUser) {
        System.out.println(loginUser);
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Authentification where login = :login";
            Query query = session.createQuery(queryString);
            query.setString("login", loginUser);
            List<Authentification> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }}

