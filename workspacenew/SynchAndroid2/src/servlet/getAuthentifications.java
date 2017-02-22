package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import model.Authentification;
import util.HibernateUtil;

@WebServlet("/getAuthentifications")
public class getAuthentifications extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Session session= HibernateUtil.getSessionFactory().openSession();
		List<Authentification> authentifications = session.createQuery("from Authentification").getResultList();
		out.write("[");
		for (int i = 0; i < authentifications.size(); i++) {
			if(i != 0) {
				out.write(", ");
			}
			Authentification authentification = authentifications.get(i);
			out.write("{");
			out.write("idUser:'" + authentification.getIdUser() + "'");
			out.write(", email:'" + authentification.getEmail() + "'");
			out.write(", login:'" + authentification.getLogin() + "'");
			out.write(", motDePasse:'" + authentification.getMotDePasse() + "'");
			out.write(", nom:'" + authentification.getNom() + "'");
			out.write(", role:'" + authentification.getRole() + "'");
			
			out.write("}");
		}
		out.write("]");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Session session= HibernateUtil.getSessionFactory().openSession();
		List<Authentification> authentifications = session.createQuery("from Authentification").getResultList();
		out.write("[");
		for (int i = 0; i < authentifications.size(); i++) {
			if(i != 0) {
				out.write(", ");
			}
			Authentification authentification = authentifications.get(i);
			out.write("{");
			out.write("idUser:'" + authentification.getIdUser() + "'");
			out.write(", email:'" + authentification.getEmail() + "'");
			out.write(", login:'" + authentification.getLogin() + "'");
			out.write(", motDePasse:'" + authentification.getMotDePasse() + "'");
			out.write(", nom:'" + authentification.getNom() + "'");
			out.write(", role:'" + authentification.getRole() + "'");
			
			out.write("}");
		}
		out.write("]");
	}

}
