package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Authentification;




@WebServlet("/EditAuthentification")
public class EditAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("0");
		String id = request.getParameter("idUser");
		System.out.println("1");
 		Authentification authentification = (Authentification) request.getSession().getAttribute("authentification");
 		System.out.println("2 - authentification" + authentification );
 		authentification.setIdUser(Integer.parseInt(id));
 		System.out.println("3");
 		authentification.fullInfo();
 		System.out.println("4");
 		response.sendRedirect("./faces/authentification.jsp");
 		System.out.println("5");
	}
}
