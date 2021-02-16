package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.entities.Donor;
//import dao.entities.Appointment;
import dao.implementation.*;
import web.controllers.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/profile","/center/profile/search","/center/profile/donor","/center/profile/hospital"})
public class ProfileController extends ServletController {
	
	//AppointmentDaoImp appointmentDao;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/profile");
		
		router.get("", () ->  this.center());
		router.get("/search", "search");
		router.get("/donor", "donor");
		router.get("/hospital", "hospital");
		
		
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
		view("admin-center/profile/admin-center");
	}
	
	public void search() {
		String type = req.getParameter("type");
		if ( type == null )
			servlet("/center/dashboard");
		else {
			switch ( type ) {
		        case "donor":
		        		donor(Long.parseLong( req.getParameter("query") ));
		        	break;
		        	
		        case "hospital":
		        		hospital();
		        	break;
		        	
		        default:
		        	servlet("/center/dashboard");
			}
		}
	}

	public void donor() {
		donor(Long.parseLong( req.getParameter("Did") ));
	}
	
	public void donor(Long id) {
		// TODO Auto-generated method stub
		Donor donor = (new DonorDaoImp()).find( id );
		donor.setAppointments(); 
		req.setAttribute("donor", donor);
		view("admin-center/profile/donor");
	}

	public void hospital() {
		// TODO Auto-generated method stub
		/*Hospital hospital = (new HospitalDaoImp()).find( Long.parseLong( req.getParameter("Hid"));
		hospital.setDemands();
		req.setAttribute("hospital", hospital);*/
		view("admin-center/profile/hospital");
	}
}
