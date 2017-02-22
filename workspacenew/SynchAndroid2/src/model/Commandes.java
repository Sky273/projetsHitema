package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import org.hibernate.Session;

import util.HibernateUtil;
public class Commandes implements Serializable{
	private static final long serialVersionUID = 1460800962120333821L;
	private List<Commande> commandes = null;
	
	public Commandes() {
	}

	public List<Commande> getCommandes() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		commandes = session.createQuery("from Commande").getResultList();
		return commandes;
	}
	public void addCommande(Integer idCommande, String adrLivraison, String client, Date dateCommande, String statutCommande, String statutLivraison, String statutPaiement) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Commande commande = new Commande();
		commande.setAdrLivraison(adrLivraison);
		commande.setClient(client);
		commande.setDateCommande(dateCommande);
		commande.setStatutCommande(statutCommande);
		commande.setStatutLivraison(statutLivraison);
		commande.setStatutPaiement(statutPaiement);
		session.save(commande);
	}
}
