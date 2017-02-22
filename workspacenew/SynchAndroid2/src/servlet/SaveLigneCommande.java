package servlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commande;
import model.Lignecommande;

/**
 * Servlet implementation class SaveLigneCommande
 */
@WebServlet("/SaveLigneCommande")
public class SaveLigneCommande extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idLigneCommande");
		String produit = request.getParameter("produit");
		String quantite = request.getParameter("quantite");
		String prix = request.getParameter("prix");
		Lignecommande ligne = (Lignecommande) request.getSession().getAttribute("lignecommande");
		ligne.setIdLigneCommande(Integer.parseInt(id));
		ligne.setCommande((Commande) request.getSession().getAttribute("commande"));
		ligne.setProduit(produit);
		ligne.setPrix(Float.parseFloat(prix));
		ligne.setQuantite(Integer.parseInt(quantite));
		ligne.updateLigne();
		request.getSession().setAttribute("lignecommande", ligne);
		response.sendRedirect("./faces/ligneCommande.jsp");
	}
}
