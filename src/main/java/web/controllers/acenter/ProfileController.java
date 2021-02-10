package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.entities.Donor;
//import dao.entities.Appointment;
import dao.implementation.*;
import web.controllers.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/profile","/center/profile/donor","/center/profile/hospital"})
public class ProfileController extends ServletController {
	
	//AppointmentDaoImp appointmentDao;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/profile");
		
		router.get("", () ->  this.center());
		router.get("/donor", () ->  this.donor( req.getParameter("Did") ));
		router.get("/hospital", () ->  this.hospital( req.getParameter("Hid") ));
		
		
		/*
		router.group("", ()-> { 
		});
		router.get("", () ->  this.showAll() );
		*/
	}
	
	private void center() {
		// TODO Auto-generated method stub
		//Session session;
		
		//req.setAttribute("center", adminCenter);
		view("admin.center/profile/admin-center");
	}

	private void donor(String Did) {
		// TODO Auto-generated method stub
		Donor donor = (new DonorDaoImp()).find( Long.parseLong( Did ));
		donor.setAppointments(); 
		req.setAttribute("donor", donor);
		view("admin.center/profile/donor");
	}

	private void hospital(String Hid) {
		// TODO Auto-generated method stub
		/*Hospital hospital = (new HospitalDaoImp()).find( Long.parseLong( req.getParameter("Hid"));
		hospital.setDemands();
		req.setAttribute("hospital", hospital);*/
		view("admin.center/profile/hospital");
	}
}
