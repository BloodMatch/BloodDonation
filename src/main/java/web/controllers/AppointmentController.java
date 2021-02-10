package web.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;
import dao.entities.User;
import dao.implementation.AppointmentDaoImp;
import dao.interfaces.IAppointmentDao;
import web.models.AppointmentModel;
import web.models.CenterModel;
import web.models.DonorModel;
import web.models.UserModel;


public class AppointmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User Auth;
	private Donor donor;
	private AppointmentDaoImp appointDao;
	
	@Override
	public void init() throws ServletException {
		super.init();
		appointDao = new AppointmentDaoImp();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		this.setAuth(request);
		
		request.setAttribute("donor", this.getDonorModel());
		request.setAttribute("user",this.getUserModel());
		
		AppointmentModel appointMod = new AppointmentModel();
		appointMod.setCities(Center.getOtherCities(donor.getCity()));
		request.setAttribute("appoint", appointMod);
		
		if(contextPath.concat("/donor/schedule").equals(reqURI)) {
			request.getRequestDispatcher("appointment.jsp").forward(request, response);			
		}
		
		if(contextPath.concat("/donor/manage").equals(reqURI)) {
			String currentDate = LocalDate.now().toString();
			// get last non expired appointment
			appointMod.setLastAppoint(appointDao.lastAppointment(donor.getDonorId()));
			
			// get center
			CenterModel centerMod = new CenterModel(appointMod.getLastAppoint().center());
			
			appointMod.getLastAppoint().getTime();
			Long daysLeft = subDate(currentDate, appointMod.getLastAppoint().getTime());
			
			request.setAttribute("daysLeft", daysLeft);
			request.setAttribute("appoint", appointMod);
			request.setAttribute("center", centerMod);
			
			
			request.getRequestDispatcher("manage-appoint.jsp").forward(request, response);			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		this.setAuth(request);
		
		request.setAttribute("donor", this.getDonorModel());
		request.setAttribute("user",this.getUserModel());
		AppointmentModel appointMod = new AppointmentModel();
		appointMod.setCities(Center.getOtherCities(donor.getCity()));
		
		if(contextPath.concat("/donor/schedule").equals(reqURI)) {
			
			String option = request.getParameter("option");
			String date = request.getParameter("donationDate");
			String city = request.getParameter("city");
			if(city == null) {
				city = donor.getCity();
			}
			
			appointMod.setDateFiltred(date);
			
			if(option.equals("date")) {
				appointMod.setAvailableCenters(Appointment.availableCenters(date, city));
				
			}else if( option.equals("today")) {
				date = LocalDate.now().toString();
				appointMod.setAvailableCenters(Appointment.availableCenters(date, city));
			}
			
			request.setAttribute("appoint", appointMod);
			
			request.getRequestDispatcher("appointment.jsp").forward(request, response);
		}
		
		if(contextPath.concat("/donor/schedule/save").equals(reqURI)) {
			
			String donationType = request.getParameter("donationType");
			String date = request.getParameter("donationDate");
			Long centerId = Long.parseLong(request.getParameter("centerId"));
			
			if(date.equals("")) {
				date = LocalDate.now().toString();
			}
			
			Appointment newAppoint = new Appointment();
			newAppoint.setDonationType(donationType);
			newAppoint.setTime(date);
			newAppoint.setCenterId(centerId);
			newAppoint.setDonorId(donor.getDonorId());
			
			newAppoint = appointDao.insert(newAppoint);
			
			appointMod.setId(newAppoint.getId());
			appointMod.setTime(newAppoint.getTime());
			appointMod.setCenterId(newAppoint.getCenterId());
			appointMod.setDonorId(newAppoint.getDonorId());
			
			request.setAttribute("appoint", appointMod);
			
			request.getRequestDispatcher("../manage-appoint.jsp").forward(request, response);
		}
		
		if(contextPath.concat("/donor/schedule/cancal").equals(reqURI)) {
			Long appointId = Long.parseLong(request.getParameter("appointId"));
			
			Appointment appoint = appointDao.find(appointId);
			appointDao.cancelAppoint(appoint);
			
			response.sendRedirect(contextPath+"/donor/menu");
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

	private Long subDate(String from, String to) {
		LocalDate d1 = LocalDate.parse(from, DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.parse(to, DateTimeFormatter.ISO_LOCAL_DATE);
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		return diff.toDays();
	}
}
