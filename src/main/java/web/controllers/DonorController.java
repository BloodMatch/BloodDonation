package web.controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.entities.User;
import dao.implementation.UserDaoImp;
import web.models.UserModel;


public class DonorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImp userDao;
	private User Auth;


	@Override
	public void init() throws ServletException {
		super.init();
		userDao = new UserDaoImp();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		Auth = (User)session.getAttribute("isLoged");
		
		UserModel userMod = new UserModel();
		userMod.setId(Auth.getId());
		userMod.setFirstName(Auth.getFirstName());
		userMod.setLastName(Auth.getLastName());
		userMod.setPhone(Auth.getPhone());
		userMod.setActive(Auth.getActive());
		userMod.setRole(Auth.getRole());

		request.setAttribute("user",userMod);
		request.getRequestDispatcher("donor/home.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getContextPath().concat("/logout").equals(request.getRequestURI())) {
			System.out.println("login out");
			HttpSession session = request.getSession();
			UserModel userMod = new UserModel();
			User user = (User)session.getAttribute("isLoged");
			userMod.setEmail(user.getEmail());
			session.setAttribute("isLoged", null);
			request.setAttribute("user", userMod);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
