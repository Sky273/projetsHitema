package model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class CommandeDAO implements Serializable{
	private static final long serialVersionUID = -380219334850403852L;

	public CommandeDAO() {
	}
	public void addCommande(Commande com) {
		System.out.println("debut addCommande");
        System.out.println("a");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trns = session.beginTransaction();
        System.out.println("b");
        try {
            System.out.println("c");
            System.out.println("d");
            session.save(com);
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
        System.out.println("fin addCommande");
    }
 
    public void deleteCommande(int idCommande) {
    	System.out.println("deleteCommande(" + idCommande + ")");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trns = session.beginTransaction();
        System.out.println("A");
        try {
            //Commande com = (Commande) session.load(Commande.class, idCommande);
        	Commande com = new Commande();
        	System.out.println("B");
        	com.setIdCommande(idCommande);
        	System.out.println("C");
            session.delete(com);
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
 
    public void updateCommande(Commande com) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(com);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            //session.flush();
            session.close();
        }
    }
    public List<Commande> getAllCommandes() {
        List<Commande> commandes = new ArrayList<Commande>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            commandes = session.createQuery("select c from Commande c").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return commandes;
    }
 
    public List<Commande> getCommandeById(String idCommande) {
        System.out.println(idCommande);
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Commande where idCommande = :id";
            Query query = session.createQuery(queryString);
            query.setString("id", idCommande);
            List<Commande> list = query.list();
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
    }
    
    public List<Lignecommande> getLignesCommande(int idCommande) {
    	List<Lignecommande> lignes;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "select l from Lignecommande l inner join l.commande where l.commande.idCommande = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", idCommande);
            lignes = query.list();
            if(lignes.size() > 0) {
            	return lignes;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    }
    public int getNewId() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	String query = "SELECT max(c.idCommande) FROM Commande c";
    	List list = session.createQuery(query).list();
    	int nextInsertId = ((Integer) list.get(0)).intValue() + 1;
    	return nextInsertId;
    }
}

