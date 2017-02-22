package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import model.Commande;
import util.HibernateUtil;

@WebServlet("/getCommandes")
public class getCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Session session= HibernateUtil.getSessionFactory().openSession();
		List<Commande> commandes = session.createQuery("from Commande").getResultList();
		out.write("[");
		for (int i = 0; i < commandes.size(); i++) {
			if(i != 0) {
				out.write(", ");
			}
			Commande commande = commandes.get(i);
			out.write("{");
			out.write("idCommande:'" + commande.getIdCommande() + "'");
			out.write(", dateCommande:'" + commande.getDateCommande().toString() + "'");
			out.write(", client:'" + commande.getClient() + "'");
			out.write(", adrLivraison:'" + commande.getAdrLivraison() + "'");
			out.write(", statutCommande:'" + commande.getStatutCommande() + "'");
			out.write(", statutLivraison:'" + commande.getStatutLivraison() + "'");
			out.write(", statutPaiement:'" + commande.getStatutPaiement() + "'");
			out.write("}");
		}
		out.write("]");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Session session= HibernateUtil.getSessionFactory().openSession();
		List<Commande> commandes = session.createQuery("from Commande").getResultList();
		out.write("[");
		for (int i = 0; i < commandes.size(); i++) {
			if(i != 0) {
				out.write(", ");
			}
			Commande commande = commandes.get(i);
			out.write("{");
			out.write("idCommande:'" + commande.getIdCommande() + "'");
			out.write(", dateCommande:'" + commande.getDateCommande().toString() + "'");
			out.write(", client:'" + commande.getClient() + "'");
			out.write(", adrLivraison:'" + commande.getAdrLivraison() + "'");
			out.write(", statutCommande:'" + commande.getStatutCommande() + "'");
			out.write(", statutLivraison:'" + commande.getStatutLivraison() + "'");
			out.write(", statutPaiement:'" + commande.getStatutPaiement() + "'");
			out.write("}");
		}
		out.write("]");
	}

}
