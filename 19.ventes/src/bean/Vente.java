package bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vente database table.
 * 
 */
@Entity
@Table(name="Vente")
public class Vente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVente;

	private String etat;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="vente")
	private List<Commande> commandes;

	//bi-directional many-to-one association to Livraison
	@OneToMany(mappedBy="vente")
	private List<Livraison> livraisons;

	//bi-directional many-to-one association to Paiement
	@OneToMany(mappedBy="vente")
	private List<Paiement> paiements;

	public Vente() {
	}

	
	public int getIdVente() {
		return this.idVente;
	}

	public void setIdVente(int idVente) {
		this.idVente = idVente;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setVente(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setVente(null);

		return commande;
	}

	public List<Livraison> getLivraisons() {
		return this.livraisons;
	}

	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public Livraison addLivraison(Livraison livraison) {
		getLivraisons().add(livraison);
		livraison.setVente(this);

		return livraison;
	}

	public Livraison removeLivraison(Livraison livraison) {
		getLivraisons().remove(livraison);
		livraison.setVente(null);

		return livraison;
	}

	public List<Paiement> getPaiements() {
		return this.paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}

	public Paiement addPaiement(Paiement paiement) {
		getPaiements().add(paiement);
		paiement.setVente(this);

		return paiement;
	}

	public Paiement removePaiement(Paiement paiement) {
		getPaiements().remove(paiement);
		paiement.setVente(null);

		return paiement;
	}

}