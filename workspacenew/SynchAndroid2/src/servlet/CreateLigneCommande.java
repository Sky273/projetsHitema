package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commande;
import model.Lignecommande;

/**
 * Servlet implementation class CreateLigneCommande
 */
@WebServlet("/CreateLigneCommande")
public class CreateLigneCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debut createLigneCommande");
		Commande commande = (Commande) request.getSession().getAttribute(("commande"));
 		Lignecommande ligne = (Lignecommande) request.getSession().getAttribute("lignecommande");
 		if(ligne == null) {
 			ligne = new Lignecommande();
 		} 
		ligne.newCommande();
	 	ligne.setCommande(commande);
	 	request.getSession().setAttribute("lignecommande", ligne);
 	    response.sendRedirect("./faces/ligneCommande.jsp");
 	    System.out.println("fin editLigneCommande");
	}
}