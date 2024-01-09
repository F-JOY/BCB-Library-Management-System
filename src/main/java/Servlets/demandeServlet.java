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
import Models.reservation;

/**
 * Servlet implementation class demandeServlet
 */
@WebServlet("/demandeServlet")
public class demandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demandeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reservation reservationModel = new reservation();
        List<reservation> reservationDetails = reservationModel.getAllReservationDetails();
        System.out.println(reservationDetails.size());
        request.setAttribute("reservationDetails", reservationDetails);
        Emprunt emprunt = new Emprunt();
		List<Emprunt>emprunProlanger=emprunt.getEmpruntsProlonges();
		 System.out.println("la taille des emprunt prol"+emprunProlanger.size());
		request.setAttribute("empruntProlangés", emprunProlanger);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("biblioPages/listDemande.jsp");
	         dispatcher.forward(request, response);
	}

	

}
