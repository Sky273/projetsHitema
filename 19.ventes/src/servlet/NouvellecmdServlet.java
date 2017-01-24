package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Commande;
import bean.Livraison;
import bean.Paiement;
import bean.Vente;
import util.HibernateUtil;

/**
 * Servlet implementation class NouvellecmdServlet
 */
@WebServlet("/NouvellecmdServlet")
public class NouvellecmdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;
	private Session session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<form method='post'action='NouvellecmdServlet'>" );
		
		out.println ("date:<input type='text' name='date'><br>"); // Afficher le champ date
		out.println ("quantite:<input type='text' name='quantite'><br>"); // Afficher le champ  quantite
		out.println ("client:<input type='text' name='client'><br>"); // Afficher le champ cliennt
		out.println ("<input type='submit' value='envoyer'><br>"); //Afficher le bouton envoyer
		out.println("</form>");
		/*Vente vente = ventes.get(0);
		out.write(vente.getIdVente()+"");*/
		
	
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		httpSession = request.getSession(true);
		if (httpSession.getAttribute("session") == null ) {
			session= HibernateUtil.getSessionFactory().openSession();
			httpSession.setAttribute("session", session);
		}
		else {
			session= (Session) httpSession.getAttribute("session");
		}
		out.println(request.getParameter("date")); //Afficher la saisie du client champ date 
		out.println(request.getParameter("quantite")); //Afficher la saisie du client champ quantite
		out.println(request.getParameter("client"));//Afficher la saisie du client champ client
		Vente vente = new Vente();
		vente.setEtat("TRUE");
		session.save(vente);
		Commande commande = new Commande();
		DateFormat formatFR = new SimpleDateFormat("DD/mm/yyyy");
		try {
			commande.setDateCommande(((Date)formatFR.parse(request.getParameter("date"))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commande.setQuantite(Integer.parseInt(request.getParameter("quantite")));
		commande.setClientCommande(request.getParameter("client"));
		commande.setEtat("TRUE");
		commande.setVente(vente);
		session.save(commande);
		response.setContentType("text/html");
		out.println("<form method='post' action='LivraisonServlet'>");
		out.println("Date livraison : <input type='text' name='dateLivraison'><br>");
		out.println("Adresse : <input type='text' name='adresse'><br>");
		out.println("<input type='text' name='idVente' value='" + vente.getIdVente() + "' style='display:none;'>");
		out.println("<input type='submit' value='Envoyer'>");
		out.println("</form>");
	}
}
