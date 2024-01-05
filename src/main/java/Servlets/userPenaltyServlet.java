package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Penalisation;
/**
 * Servlet implementation class userPenaltyServlet
 */
@WebServlet("/userPenaltyServlet")
public class userPenaltyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userPenaltyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userID = request.getParameter("ID");
		List<Penalisation> penalties = Penalisation.getPenaltiesByUserID(userID);
        System.out.println(penalties.size());
        // Ajouter les pénalités à la demande pour les afficher dans la JSP
        request.setAttribute("penalties", penalties);
		RequestDispatcher dispatcher = request.getRequestDispatcher("abonnéPages/mesPenalty.jsp");
        dispatcher.forward(request, response);
	}

	

}
