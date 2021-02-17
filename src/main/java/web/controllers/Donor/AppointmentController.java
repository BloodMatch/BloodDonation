package web.controllers.Donor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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


public class AppointmentController extends HttpServlet {
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
		
		/*
		 * GET [ donor/schedule , donor/manage ]
		 * */
		if(contextPath.concat("/donor/schedule").equals(reqURI)) {
			// Set Model
			List<String> cities =  Center.getOtherCities(donor.getCity());
			appointMod.setCitiesInput(cities);
			// Set Attributes
			request.setAttribute("appoint", appointMod);
			
			request.getRequestDispatcher("appointment.jsp").forward(request, response);			
		}
		
		if(contextPath.concat("/donor/manage").equals(reqURI)) {
			
			Appointment ap = Appointment.lastAppointment(donor.getDonorId());
			
			if(ap != null) {
				// clone center to model 
				centerMod.clone(ap.center());
				
				// get last non expired appointment
				String currentDate = LocalDate.now().toString();
				appointMod.clone(ap);
				appointMod.setDaysLeft(currentDate);
				
				request.setAttribute("appoint", appointMod);
				request.setAttribute("center", centerMod);				
			}

			request.getRequestDispatcher("manage-appoint.jsp").forward(request, response);			
		}
		
		if(contextPath.concat("/donor/history").equals(reqURI)) {
			
			List<Appointment> appoints = donor.appointments();
			// get Center for each appointment
			for (Appointment appointment : appoints) {
				appointment.center();
			}
			appointMod.setAppointments(appoints);
			
			request.setAttribute("appoint", appointMod);
			
			request.getRequestDispatcher("history.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		// Models
		AppointmentModel appointMod = new AppointmentModel();
		
		// User data
		this.setAuth(request);
		request.setAttribute("donor", this.getDonorModel());
		request.setAttribute("user",this.getUserModel());
		
		appointMod.setCitiesInput(Center.getOtherCities(donor.getCity()));
		
		/*
		 * POST : [ donor/schedule , donor/schedule/save, donor/schedule/cancel ] 
		 */
		if(contextPath.concat("/donor/schedule").equals(reqURI)) {
			// Get Parameters
			String option = request.getParameter("option");
			String date = request.getParameter("donationDate");
			String city = request.getParameter("city");

			if(city == null) city = donor.getCity();
			if(option.equals("today")) date = LocalDate.now().toString(); // currentDate
			
			// Set Model
			appointMod.setDateFiltredInput(date);
			appointMod.setAvailableCenters(Appointment.availableCenters(date, city));
			
			// Set Attributes
			request.setAttribute("appoint", appointMod);
			
			request.getRequestDispatcher("appointment.jsp").forward(request, response);
		}
		
		if(contextPath.concat("/donor/schedule/save").equals(reqURI)) {
			// Get Parameters
			String donationType = request.getParameter("donationType");
			String date = request.getParameter("donationDate");
			String time = request.getParameter("time");
			Long centerId = Long.parseLong(request.getParameter("centerId"));
			
			if(date.equals("")) date = LocalDate.now().toString(); // currentDate
			date = date.concat(" "+time);
			System.out.println(date);
			Appointment newAppoint = Appointment.create(donationType, date, centerId, donor.getDonorId());
			newAppoint = newAppoint.add();
			
			// Set Model
			appointMod.clone(newAppoint);

			response.sendRedirect(contextPath+"/donor/manage");
		}
		
		if(contextPath.concat("/donor/schedule/cancal").equals(reqURI)) {
			
			// Get Parameters
			Long appointId = Long.parseLong(request.getParameter("appointId"));
			
			Appointment appoint = Appointment.find(appointId);
			
			if(appoint.cancelAppoint()) {
				response.sendRedirect(contextPath+"/donor/menu");
			}else {
				response.sendRedirect(contextPath+"/donor/manage");
			}
		}
		
		if(contextPath.concat("/donor/feedBack").equals(reqURI)) {
			
			// Get Parameters
			Long appointId = Long.parseLong(request.getParameter("id"));
			String comment = request.getParameter("comment");
			Integer rating = Integer.parseInt(request.getParameter("rating"));

			Appointment appoint = Appointment.find(appointId);
			appoint.setComment(comment);
			appoint.setSatisfaction(rating);
			try {
				appoint.save();
				response.sendRedirect(contextPath+"/donor/history");
			}catch(Exception e) {
				response.sendRedirect(contextPath+"/donor/menu");
			}
		}		
		
	}
	
	private void setAuth(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Auth = (User)session.getAttribute("isLoged");
		donor = Auth.donor();
	}
	
	private UserModel getUserModel() {
		UserModel userMod = new UserModel();
		userMod.clone(Auth);
		return userMod;
	}
	
	private DonorModel getDonorModel() {
		DonorModel donorMod = new DonorModel();
		donorMod.clone(donor);
		return donorMod;
	}
}
