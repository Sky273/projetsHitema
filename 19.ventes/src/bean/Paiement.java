package bean;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the paiement database table.
 * 
 */
@Entity
@Table(name="Paiement")
public class Paiement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPaiement;

	@Temporal(TemporalType.DATE)
	private Date datePaiement;

	private String etat;

	private float somme;

	//bi-directional many-to-one association to Vente
	@ManyToOne
	@JoinColumn(name="idVente")
	private Vente vente;

	public Paiement() {
	}

	public int getIdPaiement() {
		return this.idPaiement;
	}

	public void setIdPaiement(int idPaiement) {
		this.idPaiement = idPaiement;
	}

	public Date getDatePaiement() {
		return this.datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public float getSomme() {
		return this.somme;
	}

	public void setSomme(float somme) {
		this.somme = somme;
	}

	public Vente getVente() {
		return this.vente;
	}

	public void setVente(Vente vente) {
		this.vente = vente;
	}

}