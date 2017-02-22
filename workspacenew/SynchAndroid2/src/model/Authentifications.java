package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;

import org.hibernate.Session;

import util.HibernateUtil;
public class Authentifications implements Serializable{
	private static final long serialVersionUID = 1460800962120333821L;
	private List<Authentification> authentifications = null;
	
	public Authentifications() {
	}

	public List<Authentification> getAuthentifications() {
		Session session= HibernateUtil.getSessionFactory().openSession();
		authentifications = session.createQuery("from Authentification").getResultList();
		return authentifications;
	}
	public void addAuthentification(Integer idUser, String email, String login, String motDePasse, String nom, String role) {
		Session session= HibernateUtil.getSessionFactory().openSession();
		Authentification authentification = new Authentification();
		authentification.setIdUser(idUser);
		authentification.setEmail(email);
		authentification.setLogin(login);
		authentification.setMotDePasse(motDePasse);
		authentification.setNom(nom);
		authentification.setRole(role);
		session.save(authentification);
	}
}
