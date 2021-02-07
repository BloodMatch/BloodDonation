package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.entities.Appointment;
import dao.implementation.AppointmentDaoImp;
import web.controllers.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/appointment/*"})
public class AppointmentController extends ServletController {
	
	AppointmentDaoImp appointmentDao;
	Appointment appointment;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/appointment");
		
		appointmentDao = new AppointmentDaoImp();
		router.get("", () ->  this.show() );
		/*router.group("", ()-> { 
		});*/
		
		
		router.post("@approve", 	() ->  this.approve() );
		router.post("@approveAll", 	() ->  this.approveAll() );
		
		router.post("@decline", 	() ->  this.decline() );
		router.post("@declineAll", 	() ->  this.declineAll() );
		
		router.post("@revoke", 		() ->  this.revoke() );
		router.post("@revokeAll", 	() ->  this.revokeAll() );
	}

	public void show() {
		
		System.out.println("getServletPath : "+req.getServletPath());
		System.out.println("getContextPath : "+req.getContextPath());
		System.out.println("getPathInfo : "+req.getPathInfo());
		
		if ( req.getParameter("state") == null )
			servlet("/center/dashboard");
		else {
			switch ( req.getParameter("state") ) {
		        case "pending":
		        		pending();
		        	break;
		        case "scheduled":
		        	scheduled();
		        	break;
		        case "done":
		        	donations();
		        	break;
		        default:
		        	servlet("/center/dashboard");
			}
		}
	}
	
	private void pending() {
		req.setAttribute("appointmentsList", appointmentDao.findAll("state", "pending"));
    	view("admin.center/appointment/pending");
	}
	
	private void scheduled() {
		req.setAttribute("appointmentsList", appointmentDao.findAll("state", "approved"));
		view("admin.center/appointment/scheduled");
	}
	
	private void donations() {
		req.setAttribute("appointmentsList", appointmentDao.findAll("state", "done"));
		view("admin.center/appointment/donations");
	}
	
	private void approve() {
		appointment =  appointmentDao.find( Long.parseLong( req.getParameter("id")) );
		
		appointment.setState("approved");
		appointment.save();
		
		servlet("/center/appointment?state=pending");
	}

	private void approveAll() {
		// TODO Auto-generated method stub
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: req.getParameterValues("idss")){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("approved");
				appointment.save();
		    }
		servlet("/center/appointment?state=pending");
	}

	private void decline() {
		appointment =  appointmentDao.find( Long.parseLong( req.getParameter("id")) );
		
		appointment.setState("declined");
		appointment.save();
		
		servlet("/center/appointment?state=pending");
	}

	private void declineAll() {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: req.getParameterValues("ids")){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("declined");
				appointment.save();
		    }
		servlet("/center/appointment?state=pending");
	}

	private void revoke() {
		appointment =  appointmentDao.find( Long.parseLong( req.getParameter("id")) );
		
		appointment.setState("revoked");
		appointment.save();
		
		servlet("/center/appointment?state=scheduled");
	}
	
	private void revokeAll() {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: req.getParameterValues("ids")){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("revoked");
				appointment.save();
		    }
		servlet("/center/appointment?state=scheduled");
	}
	
}
