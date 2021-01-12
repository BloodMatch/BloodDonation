package web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getContextPath().concat("/home").equals(request.getRequestURI())) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		if(request.getContextPath().concat("/faq").equals(request.getRequestURI())) {
			request.getRequestDispatcher("faq.jsp").forward(request, response);
		}
		
		if(request.getContextPath().concat("/contact-us").equals(request.getRequestURI())) {
			request.getRequestDispatcher("contact-us.jsp").forward(request, response);
		}
		
		if(request.getContextPath().concat("/about").equals(request.getRequestURI())) {
			request.getRequestDispatcher("about.jsp").forward(request, response);
		}
		
		//request.getRequestDispatcher("/error404.js").forward(request, response);
	}

}
