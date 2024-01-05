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
 * Servlet implementation class empruntServlet
 */
@WebServlet("/empruntServlet")
public class empruntServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empruntServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Emprunt> emprunts = Emprunt.getAllEmpruntsDetails();
		 	System.out.println(emprunts.size());
	        request.setAttribute("emprunts", emprunts);
		request.setAttribute("basePath", request.getContextPath());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("biblioPages/listEmprunt.jsp");
         dispatcher.forward(request, response);
	}

	

}
