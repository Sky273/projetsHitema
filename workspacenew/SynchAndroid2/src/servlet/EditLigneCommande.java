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
 * Servlet implementation class EditLigneCommande
 */
@WebServlet("/EditLigneCommande")
public class EditLigneCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("debut editLigneCommande");
		String id = request.getParameter("idLigneCommande");
		System.out.println("A - id:" + id);
 		Lignecommande ligne = (Lignecommande) request.getSession().getAttribute("lignecommande");
 		if (ligne == null || ligne.getIdLigneCommande() == 0) {
 			System.out.println("B");
 	 	    ligne = new Lignecommande();
 		}
 	    System.out.println("C");
 	 	ligne.setIdLigneCommande(Integer.parseInt(id));
 	 	System.out.println("D");
 	    ligne.fullInfo();
 	    System.out.println("E");
 	    request.getSession().setAttribute("lignecommande", ligne);
 		//getServletContext().setAttribute("lignecommande", ligne);
 	    System.out.println("F");
 	    response.sendRedirect("./faces/ligneCommande.jsp");
 	    System.out.println("fin editLigneCommande");
	}
}
