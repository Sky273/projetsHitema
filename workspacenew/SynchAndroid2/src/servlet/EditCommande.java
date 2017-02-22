package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Commande;
import model.CommandeDAO;

/**
 * Servlet implementation class EditCommande
 */
@WebServlet("/EditCommande")
public class EditCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("0");
		String id = request.getParameter("idCommande");
		System.out.println("1");
 		Commande commande = (Commande) request.getSession().getAttribute("commande");
 		System.out.println("2 - commande" + commande);
 		commande.setIdCommande(Integer.parseInt(id));
 		System.out.println("3");
 		commande.fullInfo();
 		System.out.println("4");
 		response.sendRedirect("./faces/commande.jsp");
 		System.out.println("5");
	}
}
