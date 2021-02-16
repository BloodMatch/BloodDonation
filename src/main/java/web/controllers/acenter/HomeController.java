package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import web.controllers.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center"})
public class HomeController extends ServletController {
	
	//AppointmentDaoImp appointmentDao;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center");
		
		router.get("", "show");
	
	}

	
	public void show() {
		view("admin-center/home");
	}
	
}
