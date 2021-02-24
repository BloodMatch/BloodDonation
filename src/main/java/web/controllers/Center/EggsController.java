package web.controllers.Center;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/eggs/*"})
public class EggsController extends ServletController {
	
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/eggs");
		
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
		
		view("admin-center/eggs");
	}
}