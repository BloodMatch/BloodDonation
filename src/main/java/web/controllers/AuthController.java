package web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import dao.entities.User;
import dao.implementation.UserDaoImp;
import dao.interfaces.IUserDao;
import web.http.ServletController;
import web.models.UserModel;

@WebServlet(urlPatterns = { "/login", "/logout"})
public class AuthController extends ServletController {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao;
	private UserModel userMod ;
    
	@Override
	public void init() throws ServletException {
		super.init();
		
		userDao = new UserDaoImp();
		
		router.setBaseURL("");
		
		router.get("/login", "login" );
		router.get("/logout", "logout" );
		router.post("/login@connect", "connect" );
	}

	
	public void login() {
		HttpSession session = req.getSession();
		userMod = new UserModel();
		req.setAttribute("user", userMod);
		view("login");
	}
	
	public void connect() {
		HttpSession session = req.getSession();
		UserModel userMod = new UserModel();
		userMod.setEmail(req.getParameter("email"));
		String password = req.getParameter("passwd");

		User user = userDao.login( userMod.getEmail() , password);
		
		if(user != null) {
			session.setAttribute("isLoged", user);
			servlet("/"+user.getRole());
		}else {
			// Alert msg case it faild
			userMod.setErrorMsg("<strong>Incorrect password or email</strong> please try again !");
			req.setAttribute("user", userMod);
			view("login");
		}
		
	}
	
	public void logout() {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("isLoged") == null) {
			UserModel  userMod = new UserModel();
			userMod.setErrorMsg("<strong>You are already loged out!</strong>");
			req.setAttribute("user", userMod);
			System.out.println("you are already loged out!!");
		}
		else{
			session.removeAttribute("isLoged");
			System.out.println("you are loged out");
		}
		view("login");
		
	}
}
	