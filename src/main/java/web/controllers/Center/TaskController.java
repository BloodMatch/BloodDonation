package web.controllers.Center;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import business.Task;
import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/taskddd"})
public class TaskController extends ServletController {
	
	@Override
	public void init() throws ServletException {
		super.init();

		router.setBaseURL("/center/task");
		
		router.get("", () ->  this.show() );
		router.post("@launch", 	() ->  this.launch( req.getParameter("tasksId") ) );
	}
	
	private void show() {
		view("admin-center/tasks");
	}
	
	private void launch(String Tid) {
		// TODO Auto-generated method stub
		Task task = new Task();
		switch ( Tid) {
	        case "1": 
	        	task.missedAppointemnt( 1 /*center.getId()*/ );
	        	break;
	        case "2": // missed appointment
	        	task.arrivedAppointemnt( 1 /*center.getId()*/);
	        	break;
	        case "3": //arrived appointment
	        	//task.expiredAppointemnt( center.getId());
	        	break;
		}
		redirectPrevious();
	}
}
