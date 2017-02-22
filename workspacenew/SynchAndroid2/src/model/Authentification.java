package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name="Authentification.findAll", query="SELECT a FROM Authentification a")
public class Authentification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUser;

	private String email;

	private String login;

	private String motDePasse; 

	private String nom;

	private String role;

	public Authentification() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	 public List<Authentification> getAllAuthentifications() {
	        List<Authentification> authentifications = new java.util.ArrayList<Authentification>();
	        AuthentificationDAO dao = new AuthentificationDAO();
	        authentifications= dao.getAllAuthentifications();
	        return authentifications;
	    }

	 public void fullInfo() {
	        AuthentificationDAO dao = new AuthentificationDAO();
	        List<Authentification> authentifications = dao.getAuthentificationByLogin(Integer.toString(idUser));
	        this.idUser = authentifications.get(0).idUser;
	        this.email = authentifications.get(0).email;
	        this.login = authentifications.get(0).login;
	        this.motDePasse = authentifications.get(0).motDePasse;
	        this.nom = authentifications.get(0).nom;
	        this.role = authentifications.get(0).role;
	        
	    }
	 private void clearAll() {
	    	this.idUser ++;
	        this.email = null;
	        this.login  = "";
	        this.motDePasse = "";
	        this.nom  = "";
	        this.role = "";
	       
	    }
}