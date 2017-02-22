package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LigneCommandeDAO;

/**
 * Servlet implementation class deleteLigneCommande
 */
@WebServlet("/deleteLigneCommande")
public class deleteLigneCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("0");
 		String id = request.getParameter("idLigneCommande");
 		System.out.println("1 - id:'" + id + "'");
 		LigneCommandeDAO dao = new LigneCommandeDAO();
 		System.out.println("2");
 		dao.deleteLigneCommande(Integer.parseInt(id));
        System.out.println("3");
        response.sendRedirect("./faces/commande.jsp");
        System.out.println("4");
 	}
}
