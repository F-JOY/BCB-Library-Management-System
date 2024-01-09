package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Emprunt;

/**
 * Servlet implementation class demandeProl
 */
@WebServlet("/demandeProl")
public class demandeProl extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public demandeProl() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emprunt emprunt = new Emprunt();
		List<Emprunt>emprunProlanger=emprunt.getEmpruntsProlonges();
	
		request.setAttribute("empruntProlangés", emprunProlanger);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("biblioPages/listDemande.jsp");
         dispatcher.forward(request, response);
	}

	

}
