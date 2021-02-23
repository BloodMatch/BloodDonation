package web.controllers.Center;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.DAOFactory;
import dao.entities.Analysis;
import dao.entities.Appointment;
import dao.implementation.AppointmentDaoImp;
import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/appointment", "/center/appointment/analysis"})
public class AppointmentController extends ServletController {
	
	//AppointmentDaoImp appointmentDao;
	Appointment appointment;
	Analysis analysis;
	
	@Override
	public void init() throws ServletException {
		super.init();

		//appointmentDao = new AppointmentDaoImp();
		
		router.setBaseURL("/center/appointment");
		
		router.get("", () ->  this.show( req.getParameter("state")) );
		/*router.group("", ()-> { 
		});*/
		
		router.post("@add", "add");
		router.post("@save", "save");
		router.post("@notify", "notif");
		
		router.post("@approve", 	() ->  this.approve( req.getParameter("id") ));
		router.post("@approveAll", 	() ->  this.approveAll( req.getParameterValues("ids") ));
		
		router.post("@decline", 	() ->  this.decline( req.getParameter("id") ));
		router.post("@declineAll", 	() ->  this.declineAll( req.getParameterValues("ids") ));
		
		router.post("@revoke", 		() ->  this.revoke( req.getParameter("id") ));
		router.post("@revokeAll", 	() ->  this.revokeAll( req.getParameterValues("ids") ));
		
		router.post("@done", 		() ->  this.done( req.getParameter("id") ));
		router.post("@doneAll", 	() ->  this.doneAll( req.getParameterValues("ids") ));
		
	}

	public void show(String state) {
		
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
		Long DonorId = Long.parseLong( req.getParameter("id") );
		String donationType = req.getParameter("donationType");
		String datetime = req.getParameter("date")+" "+req.getParameter("time");
		
		appointment = new Appointment();
		appointment.setDonorId( DonorId);
		appointment.setCenterId( 1 );
		appointment.setState( "Pending" );
		appointment.setDonationType( donationType);
		appointment.setTime( datetime );
		appointment.add();
		
		redirectPrevious();
	}
	
	public void save() {
		String datetime = req.getParameter("date")+" "+req.getParameter("time");
		Long id = Long.parseLong( req.getParameter("id") );
		
		appointment =  DAOFactory.getAppointmentDao().find( id);
		appointment.setTime( datetime);
		appointment.save();
		
		redirectPrevious();
	}
	
	public void notif() {
		System.out.println("Send notification to the -> Donor!");
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
		req.setAttribute("appointmentsList", DAOFactory.getAppointmentDao().findWhere("state", "Fulfilled"));
		view("admin-center/appointment/donations");
	}
	
	private void approve(String id) {
		appointment =  DAOFactory.getAppointmentDao().find( Long.parseLong( id) );
		appointment.book();
		redirectPrevious();
	}

	private void approveAll(String [] idss) {
		// TODO Auto-generated method stub
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: idss){  
				System.out.println(appointmentId);
				appointment =  DAOFactory.getAppointmentDao().find( Long.parseLong( appointmentId) );
				appointment.book();
		    }

		redirectPrevious();
	}

	private void decline(String id) {
		appointment =  DAOFactory.getAppointmentDao().find( Long.parseLong( id ));
		appointment.decline();
		redirectPrevious();
	}

	private void declineAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  DAOFactory.getAppointmentDao().find( Long.parseLong( appointmentId) );
				appointment.decline();
		    }

		redirectPrevious();
	}

	private void revoke(String id) {
		appointment =  DAOFactory.getAppointmentDao().find( Long.parseLong( id ));
		appointment.revoke();
		redirectPrevious();
	}
	
	private void revokeAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment = DAOFactory.getAppointmentDao().find( Long.parseLong( appointmentId) );
				appointment.revoke();
		    }

		redirectPrevious();
	}
	
	private void done(String id) {
		appointment =  DAOFactory.getAppointmentDao().find( Long.parseLong( id ));
		appointment.fulfill();
		redirectPrevious();
	}
	
	private void doneAll(String [] ids) {
		if( req.getParameterValues("ids") != null )			
			for(String appointmentId: ids){  
				System.out.println(appointmentId);
				appointment =  DAOFactory.getAppointmentDao().find( Long.parseLong( appointmentId) );
				appointment.fulfill();
		    }

		redirectPrevious();
	}
	

	
}
