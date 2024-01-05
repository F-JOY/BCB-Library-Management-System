package Servlets;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Abonné;
import Models.Penalisation;
/**
 * Servlet implementation class penaltyServlet
 */
@WebServlet("/penaltyServlet")
public class penaltyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public penaltyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Penalisation> penalties = Penalisation.getAllPenalisationsWithUsers();
		 for (Penalisation penalisation : penalties) {
		        System.out.println("Penalisation ID: " + penalisation.getId_penalisation());
		        System.out.println("Start Date: " + penalisation.getDate_debut());
		        System.out.println("End Date: " + penalisation.getDate_fin());

		        Abonné abonne = penalisation.getAbonne();
		        System.out.println("Abonné ID: " + abonne.getId_utilisateur());
		        System.out.println("Nom d'utilisateur: " + abonne.getNom());
		        // Print other Abonné fields as needed

		        System.out.println("----------------------------------------");
		    }
	        request.setAttribute("penalties", penalties);
	        request.setAttribute("basePath", request.getContextPath());
	   	 RequestDispatcher dispatcher = request.getRequestDispatcher("adminPages/listPenalty.jsp");
         dispatcher.forward(request, response);
	    }

	   
		
		
	
	

	

}
