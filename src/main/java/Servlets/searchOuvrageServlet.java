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

@WebServlet("/searchOuvrageServlet")
public class searchOuvrageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public searchOuvrageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword=request.getParameter("keywords");
		List<Ouvrage> livres = Ouvrage.searchOuvrage(keyword);
			response.setContentType("text/html;charset=UTF-8");
	        response.setCharacterEncoding("UTF-8");
	        /* ///test////
	        for (Ouvrage livre : livres) {
	            System.out.println( livre.getTitre());
	        }*/
	     // envoyer la list des livres as a request attribute
	        request.setAttribute("livres", livres);

	        // rediriger la requete vers livres.jsp
	        RequestDispatcher dispatcher = request.getRequestDispatcher("generalPages/searchResult.jsp");
	        dispatcher.forward(request, response);
	        
		 
		
		
	}

	

}
