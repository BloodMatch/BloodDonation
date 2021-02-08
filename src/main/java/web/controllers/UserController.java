package web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.entities.Donor;
import dao.entities.User;
import dao.implementation.DonorDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.IDonorDao;
import dao.interfaces.IUserDao;
import web.models.UserModel;
import web.models.UserRegisterModel;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao;
	private IDonorDao donorDao;
    
	@Override
	public void init() throws ServletException {
		super.init();
		userDao = new UserDaoImp();
		donorDao = new DonorDaoImp();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		
		if(contextPath.concat("/login").equals(reqURI)) {
			UserModel userMod = new UserModel();
			request.setAttribute("user", userMod);
			request.getRequestDispatcher("login.jsp").forward(request,  response);			
		}
		
		if(contextPath.concat("/register").equals(reqURI)) {
			UserRegisterModel userMod = (UserRegisterModel) session.getAttribute("registerUser");
	
			if(userMod == null) {
				userMod = new UserRegisterModel();
			}
			
			request.setAttribute("user", userMod);
			request.getRequestDispatcher("register.jsp").forward(request,  response);
		}
		
		if(contextPath.concat("/register2").equals(reqURI)){
			UserRegisterModel userMod = (UserRegisterModel)session.getAttribute("registerUser");
			if(userMod == null) {
				response.sendRedirect(contextPath+"/register");
			}else{
				request.getRequestDispatcher("register2.jsp").forward(request, response);
			}
			
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String contextPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		
		if(contextPath.concat("/login").equals(reqURI)) {
	
			UserModel userMod = new UserModel();
			userMod.setEmail(request.getParameter("email"));
			String password = request.getParameter("passwd");
			
			User user = userDao.login(userMod.getEmail(), password);
			
			if(user != null) {
				session.setAttribute("isLoged", user);
				
				response.sendRedirect(request.getContextPath()+"/"+user.getRole()+"/home");
			}else {
				// Alert msg case it faild
				userMod.setError(true);
				userMod.setErrorMsg("<strong>Incorrect password or email</strong> please try again !");
				request.setAttribute("user", userMod);
				request.getRequestDispatcher("login.jsp").forward(request,  response);
			}
		}
		
		if(contextPath.concat("/register").equals(reqURI)) {
			UserRegisterModel userMod = new UserRegisterModel();
			
			userMod.setRfirstName(request.getParameter("firstName"));
			userMod.setRlastName(request.getParameter("lastName"));
			userMod.setRemail(request.getParameter("email"));
			userMod.setRpassword(request.getParameter("passwd"));
			
			User newUser = userDao.findByEmail(userMod.getRemail());
			if(newUser == null) {
				session.setAttribute("registerUser", userMod);
				response.sendRedirect(contextPath.concat("/register2"));
			}else {
				userMod.setRemail("");
				userMod.setRpassword("");
				userMod.setError(true);
				userMod.setErrorMsg("<strong>This email already used</strong> please enter another email !");
				request.setAttribute("user", userMod);
				request.getRequestDispatcher("register.jsp").forward(request,  response);
			}
		}
		
		if(contextPath.concat("/register2").equals(reqURI)) {
			// firstName lastName email and password
			UserRegisterModel userMod = (UserRegisterModel)session.getAttribute("registerUser");
			
			if(userMod != null) {
				// setting up the model for the view
				userMod.setRcin(request.getParameter("cin"));
				userMod.setRbirthday(request.getParameter("birthday"));
				userMod.setRgender(request.getParameter("gender"));
				userMod.setRcity(request.getParameter("city"));
				userMod.setRphone(request.getParameter("phone"));
				userMod.setRgroup(request.getParameter("group"));
				userMod.setRzipCode(Long.parseLong(request.getParameter("zipCode")));
				String image = "default-avatar.jpg";
				
				// All donor Attributes 
				Donor donor = new Donor(
						userMod.getRfirstName(), userMod.getRlastName(),
						userMod.getRemail(), userMod.getRpassword(),
						userMod.getRphone() , userMod.getRcin(), 
						userMod.getRbirthday(), userMod.getRgender(),
						userMod.getRgroup(), userMod.getRcity(),
						userMod.getRzipCode(), image
				);
				
				Donor newDonor = donorDao.insert(donor);
				if(newDonor != null) {
					
					session.setAttribute("registerUser", null);
					System.out.println("Donor added successfully !");
					response.sendRedirect(contextPath.concat("/login"));
					
				}else{
					
					System.out.println("Donor faild !");
					
				}
					
			}else{
				response.sendRedirect(contextPath.concat("/register"));
			}		
		}
	}
}
