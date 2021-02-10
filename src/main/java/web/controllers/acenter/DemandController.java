package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

//import dao.entities.Appointment;
import dao.implementation.AppointmentDaoImp;
import web.controllers.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/demand","/center/demand/facturation"})
public class DemandController extends ServletController {
	
	//AppointmentDaoImp appointmentDao;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/demand");
		
		//appointmentDao = new AppointmentDaoImp();
		router.get("", () ->  this.show() );
		/*router.group("", ()-> { 
		});*/
		/*router.get("", () ->  this.showAll() );
		router.get("/create", () ->  this.create() );
		router.post("@change", 	() ->  this.change() );
		router.post("@save", 	() ->  this.save() );
		router.post("@remove", 	() ->  this.remove() );*/
	}
	
	public void show() {
		
		view("admin.center/demand");
	}
}
