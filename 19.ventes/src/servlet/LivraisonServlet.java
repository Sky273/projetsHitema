package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.LockMode;
import org.hibernate.Session;

import bean.Commande;
import bean.Livraison;
import bean.Vente;
import util.HibernateUtil;

/**
 * Servlet implementation class LivraisonServlet
 */
@WebServlet("/LivraisonServlet")
public class LivraisonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession httpSession;
	private Session session;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		httpSession = request.getSession(true);
		if (httpSession.getAttribute("session") == null ) {
			session= HibernateUtil.getSessionFactory().openSession();
			httpSession.setAttribute("session", session);
		}
		else {
			session= (Session) httpSession.getAttribute("session");
		}
		int idVente = Integer.parseInt(request.getParameter("idVente"));
		DateFormat formatFR = new SimpleDateFormat("DD/mm/yyyy");
		Date dateLivraison = null;
		try {
			dateLivraison = ((Date)formatFR.parse(request.getParameter("dateLivraison")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String adresse = request.getParameter("adresse");
		out.println("idVente : " + idVente);
		out.println("dateLivraison : " + dateLivraison);
		out.println("adresse : " + adresse);
		Vente vente = (Vente) session.get(Vente.class, idVente, LockMode.PESSIMISTIC_WRITE);
		Livraison liv = new Livraison();
		liv.setVente(vente);
		liv.setAdresse(adresse);
		liv.setDateLivraison(dateLivraison);
		session.save(liv);
		//vente.addLivraison(liv);
		//session.update(vente);
		response.setContentType("text/html");
		out.println("<form method='post' action='PaiementServlet'>");
		out.println("Date de paiement : <input type='text' name='datePaiement'><br>");
		out.println("Somme : <input type='text' name='montant'><br>");
		out.println("<input type='text' name='idVente' style='display:none;' value='" + idVente + "'>");
		out.println("<input type='submit' value='Envoyer'>");
		out.println("</form>");
	}
}
