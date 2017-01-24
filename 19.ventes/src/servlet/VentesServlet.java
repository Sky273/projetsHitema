package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

import bean.Commande;
import bean.Livraison;
import bean.Paiement;
import bean.Vente;
import util.HibernateUtil;

/**
 * Servlet implementation class VentesServlet
 */
@WebServlet("/VentesServlet")
public class VentesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.write("Vente");
		Session session = null;
		/* try { */
		session= HibernateUtil.getSessionFactory().openSession();
		TypedQuery query = session.createQuery("from Vente");
		List<Vente> ventes = query.getResultList();	
		/*Vente vente = ventes.get(0);
		out.write(vente.getIdVente()+"");*/
		
		out.println("<table border='1' style='border-collapse:collapse;'>");
		out.println("<tr><th>Id vente</th><th>Etat</th><th>Date Commande</th><th>Quantite commandee</th><th>Client</th><th>Etat</th><th>Date livraison</th><th>Adresse livraison</th><th>Etat</th><th>Date paiement</th><th>Somme</th><th>Etat</th></tr>");
		for(int i = 0; i < ventes.size();i++) {
			Vente vente = ventes.get(i);
			out.println("<tr>");
			out.println("<td>");
			out.write(vente.getIdVente()+"");
			out.println("</td><td>");
			out.println(vente.getEtat());
			out.println("</td>");
			TypedQuery queryCommande = session.createQuery("from Commande where idVente = :idVente");
			queryCommande.setParameter("idVente", vente.getIdVente());
			List<Commande> commandes = queryCommande.getResultList();
			if(commandes.size() != 0) {
				Commande commande = commandes.get(0);
				out.println("<td>");
				out.println(commande.getDateCommande());
				out.println("</td><td>");
				out.println(commande.getQuantite());
				out.println("</td><td>");
				out.println(commande.getClientCommande());
				out.println("</td><td>");
				out.println(commande.getEtat());
				out.println("</td>");
			} else {
				out.println("<td></td><td></td><td></td><td></td>");
			}
			TypedQuery queryLivraison = session.createQuery("from Livraison where idVente = :idVente");
			queryLivraison.setParameter("idVente", vente.getIdVente());
			List<Livraison> livraisons = queryLivraison.getResultList();
			if(livraisons.size() != 0) {
				Livraison livraison = livraisons.get(0);
				out.println("<td>");
				out.println(livraison.getDateLivraison());
				out.println("</td><td>");
				out.println(livraison.getAdresse());
				out.println("</td><td>");
				out.println(livraison.getEtat());
				out.println("</td>");
			} else {
				out.println("<td></td><td></td><td></td>");
			}
			TypedQuery queryPaiement = session.createQuery("from Paiement where idVente = :idVente");
			queryPaiement.setParameter("idVente", vente.getIdVente());
			List<Paiement> paiements = queryPaiement.getResultList();
			if(paiements.size() != 0) {
				Paiement paiement = paiements.get(0);
				out.println("<td>");
				out.println(paiement.getDatePaiement());
				out.println("</td><td>");
				out.println(paiement.getSomme());
				out.println("</td><td>");
				out.println(paiement.getEtat());
				out.println("</td>");
			} else {
				out.println("<td></td><td></td><td></td>");
			}
			out.println("</tr>");
		}
		out.println("</table>");
		session.close();
		/*} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) {
				session.close();
			}
		} */
	}

}
