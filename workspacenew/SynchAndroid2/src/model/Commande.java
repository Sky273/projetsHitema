package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCommande;

	private String adrLivraison;

	private String client;

	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	private String statutCommande;

	private String statutLivraison;

	private String statutPaiement;

	//bi-directional many-to-one association to Lignecommande
	@OneToMany(mappedBy="commande")
	private List<Lignecommande> lignecommandes;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getAdrLivraison() {
		return this.adrLivraison;
	}

	public void setAdrLivraison(String adrLivraison) {
		this.adrLivraison = adrLivraison;
	}

	public String getClient() {
		return this.client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getStatutCommande() {
		return this.statutCommande;
	}

	public void setStatutCommande(String statutCommande) {
		this.statutCommande = statutCommande;
	}

	public String getStatutLivraison() {
		return this.statutLivraison;
	}

	public void setStatutLivraison(String statutLivraison) {
		this.statutLivraison = statutLivraison;
	}

	public String getStatutPaiement() {
		return this.statutPaiement;
	}

	public void setStatutPaiement(String statutPaiement) {
		this.statutPaiement = statutPaiement;
	}

	public List<Lignecommande> getLignecommandes() {
		CommandeDAO dao = new CommandeDAO();
		this.lignecommandes = dao.getLignesCommande(idCommande);
		return this.lignecommandes;
	}

	public void setLignecommandes(List<Lignecommande> lignecommandes) {
		this.lignecommandes = lignecommandes;
	}

	public Lignecommande addLignecommande(Lignecommande lignecommande) {
		getLignecommandes().add(lignecommande);
		lignecommande.setCommande(this);

		return lignecommande;
	}

	public Lignecommande removeLignecommande(Lignecommande lignecommande) {
		getLignecommandes().remove(lignecommande);
		lignecommande.setCommande(null);

		return lignecommande;
	}
	
	public void saveCommande() {
        CommandeDAO dao = new CommandeDAO();
        dao.addCommande(this);
        clearAll();
    }
    public void updateCommande() {
        CommandeDAO dao = new CommandeDAO();
        dao.updateCommande(this);
        clearAll();
    }
    public void deleteCommande() {
    	System.out.println("debut deleteCommande");
        CommandeDAO dao = new CommandeDAO();
        dao.deleteCommande(idCommande);
        clearAll();
        System.out.println("fin deleteCommande");
    }
    public void deleteCommande(Integer idCommande) {
    	System.out.println("debut deleteCommande");
        CommandeDAO dao = new CommandeDAO();
        dao.deleteCommande(idCommande);
        clearAll();
        System.out.println("fin deleteCommande");
    }
 
    public List<Commande> getAllCommandes() {
        List<Commande> commandes = new java.util.ArrayList<Commande>();
        CommandeDAO dao = new CommandeDAO();
        commandes = dao.getAllCommandes();
        return commandes;
    }
 
    public void fullInfo() {
        CommandeDAO dao = new CommandeDAO();
        List<Commande> commandes = dao.getCommandeById(Integer.toString(idCommande));
        this.idCommande = commandes.get(0).idCommande;
        this.dateCommande = commandes.get(0).dateCommande;
        this.client = commandes.get(0).client;
        this.adrLivraison = commandes.get(0).adrLivraison;
        this.statutCommande = commandes.get(0).statutCommande;
        this.statutPaiement = commandes.get(0).statutPaiement;
        this.statutLivraison = commandes.get(0).statutLivraison;
    }
 
    private void clearAll() {
    	this.idCommande ++;
        this.dateCommande = null;
        this.client = "";
        this.adrLivraison = "";
        this.statutCommande = "";
        this.statutPaiement = "";
        this.statutLivraison = "";
    }
    
    public void newCommande() {
    	CommandeDAO dao = new CommandeDAO();
    	this.idCommande = dao.getNewId();
        this.dateCommande = null;
        this.client = "";
        this.adrLivraison = "";
        this.statutCommande = "Nouvelle";
        this.statutPaiement = "Non Payee";
        this.statutLivraison = "Non Livree";    	
    }

}