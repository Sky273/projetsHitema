package bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the livraison database table.
 * 
 */
@Entity
@Table(name="Livraison")
public class Livraison implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLivraison;

	private String adresse;

	@Temporal(TemporalType.DATE)
	private Date dateLivraison;

	private String etat;

	//bi-directional many-to-one association to Vente
	@ManyToOne
	@JoinColumn(name="idVente")
	private Vente vente;

	public Livraison() {
	}

	public int getIdLivraison() {
		return this.idLivraison;
	}

	public void setIdLivraison(int idLivraison) {
		this.idLivraison = idLivraison;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateLivraison() {
		return this.dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Vente getVente() {
		return this.vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

}