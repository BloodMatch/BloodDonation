package web.controllers.Center;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center", "/center/home"})

public class HomeController extends ServletController {
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center");
			
		router.get("", "index");
		router.get("/home", "index");
	
	}

	
	public void index() {
		view("admin-center/home");
	}
	
}
