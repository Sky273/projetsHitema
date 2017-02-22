package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;


/**
 * The persistent class for the lignecommande database table.
 * 
 */
@Entity
@NamedQuery(name="Lignecommande.findAll", query="SELECT l FROM Lignecommande l")
public class Lignecommande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idLigneCommande;

	private float prix;

	private String produit;

	private int quantite;
	 
	//bi-directional many-to-one association to Commande
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande;

	public Lignecommande() {
	}

	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getProduit() {
		return this.produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return this.commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public void toto() {
    	System.out.println("===========================================toto");

    }

    public void updateLigne() {
    	System.out.println("debut updateLigneCommande");
        LigneCommandeDAO dao = new LigneCommandeDAO();
        dao.updateLigneCommande(this);
        System.out.println("id lignecommande : " + this.idLigneCommande);
        System.out.println("fin updateLigneCommande");
    }
    public void fullInfo() {
    	System.out.println("alpha");
        LigneCommandeDAO dao = new LigneCommandeDAO();
        System.out.println("bravo");
        List<Lignecommande> lignes = dao.getLigneCommandeById(idLigneCommande);
        System.out.println("charlie");
        System.out.println("lignes : " + lignes + " - taille : " + lignes.size());
        this.idLigneCommande = lignes.get(0).idLigneCommande;
        System.out.println("id : " + this.idLigneCommande);
        System.out.println("delta");
        this.produit = lignes.get(0).produit;
        System.out.println("echo - produit : " + lignes.get(0).produit);
        this.quantite = lignes.get(0).quantite;
        System.out.println("fox");
        this.prix = lignes.get(0).prix;
        System.out.println("golf");
    }
    public void newCommande() {
    	LigneCommandeDAO dao = new LigneCommandeDAO();
    	this.idLigneCommande = dao.getNewId();
    	this.produit = "";
    	this.quantite = 0;
    	this.prix = 0;
    }
}