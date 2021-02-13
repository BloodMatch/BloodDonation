package web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;
import dao.entities.User;
import web.models.CenterModel;
import web.models.DonorModel;
import web.models.UserModel;
import web.models.Donor.AppointmentModel;


public class DonorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User Auth;
	private Donor donor;


	@Override
	public void init() throws ServletException {
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		
		// Model needed
		AppointmentModel appointMod = new AppointmentModel();
		CenterModel centerMod = new CenterModel();
		
		// User date
		this.setAuth(request);
		request.setAttribute("donor", this.getDonorModel());
		request.setAttribute("user",this.getUserModel());
		
		
		if(contextPath.concat("/donor/home").equals(reqURI)) {
			request.getRequestDispatcher("home.jsp").forward(request, response);			
		}
		
		if(contextPath.concat("/donor/profile").equals(reqURI)) {
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		
		if(contextPath.concat("/donor/profile/edit").equals(reqURI)) {
			request.getRequestDispatcher("../edit-profile.jsp").forward(request, response);;
		}
		
		if(contextPath.concat("/donor/password").equals(reqURI)) {
			request.getRequestDispatcher("edit-password.jsp").forward(request, response);;
		}
		
		if(contextPath.concat("/donor/menu").equals(reqURI)) {
			
			Appointment ap = Appointment.lastDonation(donor.getDonorId());
			
			if(ap != null) {
				Center center  = Center.find(ap.getCenterId());
				appointMod.clone(ap);
				centerMod.clone(center);
				
				request.setAttribute("center", centerMod);
				request.setAttribute("appoint", appointMod);
			}
				
				
			request.getRequestDispatcher("menu.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		
		// User Data
		this.setAuth(request);
		
		// Models
		UserModel userMod = new UserModel();
		
		//POST edit profile
		if(contextPath.concat("/donor/profile/edit").equals(reqURI)) {
			request.getParameter("firstName");
			request.getParameter("lastName");
			request.getParameter("email");
			request.getParameter("phone");
			request.getParameter("birthday");
			request.getParameter("city");
			request.getParameter("zipCode");
			
			try {
				
			}catch(Exception e) {
				
			}
		}
		
		// POST logout 
		if(contextPath.concat("/donor/logout").equals(reqURI)) {
			HttpSession session = request.getSession();
			session.setAttribute("isLoged", null);
			userMod.setEmail(Auth.getEmail());
			
			request.setAttribute("user", userMod);
			
			response.sendRedirect(request.getContextPath()+"/login");
		}
	}
	
	private void setAuth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Auth = (User)session.getAttribute("isLoged");
		donor = Auth.donor();
	}
	
	private UserModel getUserModel() {
		return new UserModel(
				Auth.getId(), Auth.getEmail(), Auth.getFirstName(),
				Auth.getLastName(), Auth.getPhone(), Auth.getRole(), Auth.getActive()
			);
	}
	
	private DonorModel getDonorModel() {
		return new DonorModel(
				donor.getDonorId(), donor.getCin(), donor.getBirthDay(),
				donor.getGender(), donor.getGroup(), donor.getCity(),
				donor.getZipCode(), donor.getImage()
			);
	}

}
