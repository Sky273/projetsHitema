package model;

import java.util.List;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class LoginBean {
	private String username;
	private String password;
	private int role;
 
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
 
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
 
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
 
	
	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String login() {
		AuthentificationDAO dao = new AuthentificationDAO();
		String role;
		List<Authentification> auths = dao.getAuthentificationByLogin(username);
		if(auths == null || auths.size() == 0) {
			return "failure";
		} else {
			if(auths.get(0).getMotDePasse().equals(password)) {
				role = auths.get(0).getRole();
				switch(role) {
				case "Commercial":
					this.setRole(0);
					break;
				case "Comptable":
					this.setRole(1);
					break;

				case "Responsable Livraison":
					this.setRole(2);
					break;
				case "Administrateur":
					this.setRole(3);
					return "administration";
				default:
					this.setRole(-1);
					break;
				}
				return "success";
			} else {
				return "failure";
			}
		}
	}
	
	public String getRoleLib() {
		String[] roles = {"Commercial", "Comptable", "Responsable Livraison", "Administrateur"};
		return roles[role];
	}

	public String getPageLib() {
		String[] pages = {"Commande", "Paiement","Bon de livraison", "Administration"};
		return pages[role];
		
	}

	public String getPageLibs() {
		String[] pages = {"Commandes", "Paiements", "Bons de livraison", "Administration"};
		return pages[role];
	}
	
	public String getPageLigneLib() {
		String[] pages = {"Ligne de Commande", "Ligne de Paiement", "Ligne de Bon de livraison", "Administration"};
		return pages[role];
	}

	public String getPageLigneLibs() {
		String[] pages = {"Lignes de Commande", "Lignes de Paiement", "Lignes de Bon de livraison", "Administration"};
		return pages[role];
	}
	
}