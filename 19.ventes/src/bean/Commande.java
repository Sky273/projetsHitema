package bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@Table(name="Commande")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCommande;

	private String clientCommande;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	private String etat;

	private int quantite;

	//bi-directional many-to-one association to Vente
	@ManyToOne
	@JoinColumn(name="idVente")
	private Vente vente;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getClientCommande() {
		return this.clientCommande;
	}

	public void setClientCommande(String clientCommande) {
		this.clientCommande = clientCommande;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Vente getVente() {
		return this.vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

}