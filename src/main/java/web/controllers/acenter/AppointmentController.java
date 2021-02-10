package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.entities.Appointment;
import dao.implementation.AppointmentDaoImp;
import web.controllers.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/appointment", "/center/appointment/analysis"})
public class AppointmentController extends ServletController {
	
	AppointmentDaoImp appointmentDao;
	Appointment appointment;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/appointment");
		
		appointmentDao = new AppointmentDaoImp();
		
		router.get("", () ->  this.show(req.getParameter("state")) );
		/*router.group("", ()-> { 
		});*/
		router.post("@approve", 	() ->  this.approve( req.getParameter("id") ));
		router.post("@approveAll", 	() ->  this.approveAll( req.getParameterValues("ids") ));
		
		router.post("@decline", 	() ->  this.decline( req.getParameter("id") ));
		router.post("@declineAll", 	() ->  this.declineAll( req.getParameterValues("ids") ));
		
		router.post("@revoke", 		() ->  this.revoke( req.getParameter("id") ));
		router.post("@revokeAll", 	() ->  this.revokeAll( req.getParameterValues("ids") ));
		
		router.post("@done", 		() ->  this.done( req.getParameter("id") ));
		router.post("@doneAll", 	() ->  this.doneAll( req.getParameterValues("ids") ));
		
		router.get("/analysis", 	() ->  this.analysis(req.getParameter("id")) );
	}

	public void show(String state) {
		
		System.out.println("getServletPath : "+req.getServletPath());
		System.out.println("getContextPath : "+req.getContextPath());
		System.out.println("getPathInfo : "+req.getPathInfo());
		
		if ( state == null )
			servlet("/center/dashboard");
		else {
			switch ( state ) {
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
		req.setAttribute("appointmentsList", appointmentDao.findAll("state", "Pending"));
    	view("admin.center/appointment/pending");
	}
	
	private void scheduled() {
		req.setAttribute("bookedAppointmentsList", appointmentDao.findAll("state", "Booked"));
		req.setAttribute("arrivedAppointmentsList", appointmentDao.findAll("state", "Arrived"));
		view("admin.center/appointment/scheduled");
	}
	
	private void donations() {
		req.setAttribute("appointmentsList", appointmentDao.findAll("state", "Fulfilled"));
		view("admin.center/appointment/donations");
	}
	
	private void approve(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id) );
		
		appointment.setState("Booked");
		appointment.save();
		
		redirect(req.getHeader("referer"));
	}

	private void approveAll(String [] idss) {
		// TODO Auto-generated method stub
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: idss){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("Booked");
				appointment.save();
		    }

		redirect(req.getHeader("referer"));
	}

	private void decline(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id ));
		
		appointment.setState("Declined");
		appointment.save();
		
		redirect(req.getHeader("referer"));
	}

	private void declineAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("Declined");
				appointment.save();
		    }

		redirect(req.getHeader("referer"));
	}

	private void revoke(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id ));
		
		appointment.setState("Revoked");
		appointment.save();
		
		redirect(req.getHeader("referer"));
	}
	
	private void revokeAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("Revoked");
				appointment.save();
		    }

		redirect(req.getHeader("referer"));
	}
	
	private void done(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id ));
		
		appointment.setState("Fulfilled");
		appointment.save();
		
		redirect(req.getHeader("referer"));
	}
	
	private void doneAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("Fulfilled");
				appointment.save();
		    }

		redirect(req.getHeader("referer"));
	}
	
	private void analysis(String id) {
		view("admin.center/appointment/analysis");
	}
	
}
