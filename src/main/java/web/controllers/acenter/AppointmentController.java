package web.controllers.acenter;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.DAOFactory;
import dao.entities.Appointment;
import dao.implementation.AppointmentDaoImp;
import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/appointment", "/center/appointment/analysis"})
public class AppointmentController extends ServletController {
	
	AppointmentDaoImp appointmentDao;
	Appointment appointment;
	
	@Override
	public void init() throws ServletException {
		super.init();

		appointmentDao = new AppointmentDaoImp();
		
		router.setBaseURL("/center/appointment");
		
		router.get("", () ->  this.show( req.getParameter("state")) );
		/*router.group("", ()-> { 
		});*/
		
		router.post("@add", "add");
		router.post("@save", "save");
		
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
	
	public void add() {
		System.out.println(Long.parseLong( req.getParameter("id") ));
		Appointment  appointment = new Appointment();
		appointment.setDonorId( Long.parseLong( req.getParameter("id") ));
		appointment.setCenterId( 1 );
		appointment.setState( "Pending" );
		appointment.setDonationType(req.getParameter("donationType"));
		appointment.setTime(req.getParameter("date")+" "+req.getParameter("time"));
		appointment.add();
		redirectPrevious();
	}
	
	public void save() {
		System.out.println(Long.parseLong( req.getParameter("id") ));
		
		appointment =  appointmentDao.find( Long.parseLong( req.getParameter("id") ) );
		appointment.setTime(req.getParameter("date")+" "+req.getParameter("time"));
		
		appointment.save();
		
		redirectPrevious();
	}
	
	private void pending() {
		req.setAttribute("appointmentsList", DAOFactory.getAppointmentDao().findWhere("state", "Pending"));
		
    	view("admin-center/appointment/pending");
	}
	
	private void scheduled() {
		req.setAttribute("bookedAppointmentsList", DAOFactory.getAppointmentDao().findWhere("state", "Booked"));
		req.setAttribute("arrivedAppointmentsList", DAOFactory.getAppointmentDao().findWhere("state", "Arrived"));
		view("admin-center/appointment/scheduled");
	}
	
	private void donations() {
		req.setAttribute("appointmentsList", appointmentDao.findWhere("state", "Fulfilled"));
		view("admin-center/appointment/donations");
	}
	
	private void approve(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id) );
		
		appointment.setState("Booked");
		appointment.save();
		
		redirectPrevious();
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

		redirectPrevious();
	}

	private void decline(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id ));
		
		appointment.setState("Declined");
		appointment.save();
		
		redirectPrevious();
	}

	private void declineAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("Declined");
				appointment.save();
		    }

		redirectPrevious();
	}

	private void revoke(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id ));
		
		appointment.setState("Revoked");
		appointment.save();
		
		redirectPrevious();
	}
	
	private void revokeAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("Revoked");
				appointment.save();
		    }

		redirectPrevious();
	}
	
	private void done(String id) {
		appointment =  appointmentDao.find( Long.parseLong( id ));
		
		appointment.setState("Fulfilled");
		appointment.save();
		
		redirectPrevious();
	}
	
	private void doneAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  appointmentDao.find( Long.parseLong( appointmentId) );
				appointment.setState("Fulfilled");
				appointment.save();
		    }

		redirectPrevious();
	}
	
	private void analysis(String id) {
		view("admin-center/appointment/analysis");
	}
	
}
