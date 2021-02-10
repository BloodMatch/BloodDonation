package web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.entities.Donor;
import dao.entities.User;
import dao.implementation.UserDaoImp;
import web.models.DonorModel;
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
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		HttpSession session = request.getSession();
		Auth = (User)session.getAttribute("isLoged");
		
		Donor donor = Auth.donor();
		
		UserModel userMod = new UserModel(
				Auth.getId(), Auth.getEmail(), Auth.getFirstName(),
				Auth.getLastName(), Auth.getPhone(), Auth.getRole(), Auth.getActive()
			);
		
		DonorModel donorMod = new DonorModel(
					donor.getDonorId(), donor.getCin(), donor.getBirthDay(),
					donor.getGender(), donor.getGroup(), donor.getCity(),
					donor.getZipCode(), donor.getImage()
				);
		
		request.setAttribute("donor", donorMod);
		request.setAttribute("user",userMod);
		
		if(contextPath.concat("/donor/home").equals(reqURI)) {
			request.getRequestDispatcher("home.jsp").forward(request, response);			
		}
		
		if(contextPath.concat("/donor/profile").equals(reqURI)) {
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		
		if(contextPath.concat("/donor/menu").equals(reqURI)) {
			request.getRequestDispatcher("menu.jsp").forward(request, response);			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getContextPath().concat("/donor/logout").equals(request.getRequestURI())) {
			HttpSession session = request.getSession();
			UserModel userMod = new UserModel();
			User user = (User)session.getAttribute("isLoged");
			session.setAttribute("isLoged", null);
			userMod.setEmail(user.getEmail());
			request.setAttribute("user", userMod);
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}

}
