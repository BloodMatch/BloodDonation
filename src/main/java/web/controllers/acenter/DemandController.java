package web.controllers.acenter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import web.controllers.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/demand","/center/demand/facturation"})
public class DemandController extends ServletController {
	
	//DemandDaoImp demandDao;
	//Demand demand;
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/demand");
		
		//demandDao = new DemandDaoImp();
		router.get("", () ->  this.show() );
		
	}
	
	public void show() {
		
		view("admin-center/demand/index");
	}
}
