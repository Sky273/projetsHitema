package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthentificationDAO;



@WebServlet("/deleteAuthentification ")
public class deleteAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		System.out.println("0");
 		String id = request.getParameter("idUser");
 		System.out.println("1 - id:'" + id + "'");
 		AuthentificationDAO dao = new AuthentificationDAO();
 		System.out.println("2");
        dao.deleteAuthentification(Integer.parseInt(id));
        System.out.println("3");
      //RequestDispatcher rd  = request.getRequestDispatcher("/SynchAndroid2/faces/commande.jsp");
        //System.out.println("4");
        //rd.forward(request, response);
        response.sendRedirect("./faces/Authentification.jsp");
        System.out.println("5");
 	}
}
