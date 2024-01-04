package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Bibliothecaire;

/**
 * Servlet implementation class biblioServlet
 */
@WebServlet("/biblioServlet")
public class biblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public biblioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   List<Bibliothecaire> bibliothecaires = Bibliothecaire.getAllBiblio();
             System.out.println(bibliothecaires.size());
	        // Set the list as an attribute in the request
	        request.setAttribute("bibliothecaires", bibliothecaires);
	        request.setAttribute("basePath", request.getContextPath());
	       
		 RequestDispatcher dispatcher = request.getRequestDispatcher("adminPages/listBiblio.jsp");
         dispatcher.forward(request, response);
	}

	

}
