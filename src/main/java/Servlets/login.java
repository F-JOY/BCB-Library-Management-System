package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.Gestionnair;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    
            throws ServletException, IOException {
    	 
        // Récupérer les paramètres du formulaire
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Gestionnair gestionnaire = Gestionnair.verifyConnexion(username, password);

        if (gestionnaire != null) {
            // Authentification réussie, rediriger vers la page d'accueil du gestionnaire
        	System.out.println(gestionnaire.getNom());
            HttpSession session = request.getSession();
            session.setAttribute("gestionnaire", gestionnaire);
            request.setAttribute("gestionnaire", gestionnaire);
           // response.sendRedirect("adminPages/gestionnaire.jsp");
            request.setAttribute("basePath", request.getContextPath());
            RequestDispatcher dispatcher = request.getRequestDispatcher("adminPages/gestionnaire.jsp");
            dispatcher.forward(request, response);

        } else {
            // Authentification échouée, rediriger vers une page d'erreur
            response.sendRedirect("generalPages/loginError.html");
        }
    }

	

}
