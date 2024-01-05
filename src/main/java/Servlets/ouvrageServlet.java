package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Ouvrage;

/**
 * Servlet implementation class ouvrageServlet
 */
@WebServlet("/ouvrageServlet")
public class ouvrageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ouvrageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Ouvrage> ouvrages = Ouvrage.getAllOuvrages();
		 System.out.println(ouvrages.size());
	        request.setAttribute("ouvrages", ouvrages);
	        request.setAttribute("basePath", request.getContextPath());
		 RequestDispatcher dispatcher = request.getRequestDispatcher("biblioPages/listOuvrage.jsp");
         dispatcher.forward(request, response);
	}

	

}
