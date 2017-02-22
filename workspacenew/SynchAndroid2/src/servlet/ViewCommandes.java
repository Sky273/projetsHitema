package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Commande;

/**
 * Servlet implementation class ViewCommandes
 */
@WebServlet("/ViewCommandes")
public class ViewCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewCommandes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Commande commande = null;
		try {
			commande = (Commande) request.getSession().getAttribute("commande");
		} catch(Exception e) {
		}
		if(commande == null) {
			commande = new Commande();
		}
		commande.newCommande();
		response.sendRedirect("./faces/commandes.jsp");
	}

}
