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
/**
 * Servlet implementation class abonneServelt
 */
@WebServlet("/abonneServelt")
public class abonneServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public abonneServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Abonné> abonnes = null;

	        // Retrieve the list of subscribers
			abonnes = Abonné.getAllAbonnés(); // Implement this method in your Abonné class
             System.out.println(abonnes.size());
			// Set the list as a request attribute
			request.setAttribute("abonnes", abonnes);
			 request.setAttribute("basePath", request.getContextPath());
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("adminPages/listeAbonnes.jsp");
         dispatcher.forward(request, response);
         
         
	}

	

}
