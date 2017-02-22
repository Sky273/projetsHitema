package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CommandeDAO;

/**
 * Servlet implementation class deleteCommande
 */
@WebServlet("/deleteCommande")
public class deleteCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("0");
 		String id = request.getParameter("idCommande");
 		System.out.println("1 - id:'" + id + "'");
 		CommandeDAO dao = new CommandeDAO();
 		System.out.println("2");
        dao.deleteCommande(Integer.parseInt(id));
        System.out.println("3");
        response.sendRedirect("./faces/commandes.jsp");
        System.out.println("4");
 	}
}
