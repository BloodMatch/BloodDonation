package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.DAOFactory;
import dao.entities.Donor;
import dao.implementation.*;
import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/profile","/center/profile/search","/center/profile/donor","/center/profile/hospital"})
public class ProfileController extends ServletController {
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/profile");
		
		router.get("", () ->  this.center());
		router.get("/donor", "donor");
		router.get("/search", "search");
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
		        		donor(req.getParameter("query") );
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
		//donor(req.getParameter("Did") );
		// TODO Auto-generated method stub
		//Donor donor = (new DonorDaoImp()).find( id );
		Donor donor = DAOFactory.getDonorDao().find( Long.parseLong(req.getParameter("Did")) );
		donor.setAppointments(); 
		req.setAttribute("donor", donor);
		view("admin-center/profile/donor");
	}
	
	public void donor(String cin) {
		// TODO Auto-generated method stub
		//Donor donor = (new DonorDaoImp()).find( id );
		Donor donor = DAOFactory.getDonorDao().findByCin( cin);
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
