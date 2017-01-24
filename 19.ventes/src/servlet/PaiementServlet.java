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

import bean.Livraison;
import bean.Paiement;
import bean.Vente;
import util.HibernateUtil;

/**
 * Servlet implementation class PaiementServlet
 */
@WebServlet("/PaiementServlet")
public class PaiementServlet extends HttpServlet {
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
		Date datePaiement = null;
		try {
			datePaiement = ((Date)formatFR.parse(request.getParameter("datePaiement")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float montant = Float.parseFloat(request.getParameter("montant"));
		Vente vente = (Vente) session.get(Vente.class, idVente, LockMode.PESSIMISTIC_WRITE);
		Paiement paie = new Paiement();
		paie.setVente(vente);
		paie.setSomme(montant);
		paie.setDatePaiement(datePaiement);
		session.save(paie);
		response.setContentType("text/html");
		out.println("<h1>Opération effectuée avec succès</h1>");
	}
}
