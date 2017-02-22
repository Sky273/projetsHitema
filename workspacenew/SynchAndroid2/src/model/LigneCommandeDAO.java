package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class LigneCommandeDAO implements Serializable {
	private static final long serialVersionUID = 6699189054775211312L;

	public LigneCommandeDAO() {
	}
	public void addLigneCommande(Lignecommande ligne) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trns = session.beginTransaction();
        try {
            session.save(ligne);
            trns.commit();
        } catch (Exception e) {
            if (trns != null) {
                trns.rollback();
             }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
 
    public void deleteLigneCommande(int idLigneCommande) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trns = session.beginTransaction();
        try {
        	
        	Lignecommande ligne = new Lignecommande();
        	ligne.setIdLigneCommande(idLigneCommande);
            session.delete(ligne);
            trns.commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
 
    public void updateLigneCommande(Lignecommande ligne) {
    	Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
    	try {
    		System.out.println("debut updateLigneCommande");
    		System.out.println("ligne : " + ligne);
    		System.out.println("deux");
    		System.out.println("trois");
            trns = session.beginTransaction();
            System.out.println("quatre");
            session.saveOrUpdate(ligne);
            System.out.println("cinq");
            //session.getTransaction().commit();
            System.out.println("six");
        } catch (Exception e) {
        	System.out.println("sept");
            if (trns != null) {
            	System.out.println("huit");
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
        	System.out.println("neuf");
        	session.flush();
        	session.close();
        }
    }
    
    public List<Lignecommande> getLigneCommandeById(int idLigneCommande) {
    	System.out.println("a");
    	Transaction trns = null;
    	System.out.println("b");
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	System.out.println("c");
    	List<Lignecommande> lignes;
    	System.out.println("d");
        try {
        	System.out.println("e");
        	trns = session.beginTransaction();
        	System.out.println("f");
            String queryString = "select l from Lignecommande l where l.idLigneCommande = :id";
            System.out.println("g");
            Query query = session.createQuery(queryString);
            System.out.println("h");
            query.setInteger("id", idLigneCommande);
            System.out.println("i");
            lignes = query.list();
            System.out.println("j");
            if(lignes.size() > 0) {
            	System.out.println("k");
            	return lignes;
            }
        } catch (RuntimeException e) {
        	System.out.println("l");
            e.printStackTrace();
        } finally {
        	System.out.println("m");
        	session.flush();
            session.close();
            System.out.println("n");
        }
        System.out.println("o");
        return null;
    }
    
    public int getNewId() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	String query = "SELECT max(l.idLigneCommande) FROM Lignecommande l";
    	List list = session.createQuery(query).list();
    	int nextInsertId = ((Integer) list.get(0)).intValue() + 1;
    	return nextInsertId;
    }
}