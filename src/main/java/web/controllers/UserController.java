package web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.entities.Donor;
import dao.entities.User;
import dao.implementation.BloodDaoImp;
import dao.implementation.DonorDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.IBloodDao;
import dao.interfaces.IDonorDao;
import dao.interfaces.IUserDao;
import web.models.UserModel;
import web.models.UserRegisterModel;


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserDao userDao;
	private IDonorDao donorDao;
	private IBloodDao bloodDao;
    
	@Override
	public void init() throws ServletException {
		super.init();
		userDao = new UserDaoImp();
		donorDao = new DonorDaoImp();
		bloodDao = new BloodDaoImp();
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
				userMod.setBloods(bloodDao.all());
				
				request.setAttribute("bloods", userMod.getBloods());
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
			userMod.setEmail((String)request.getParameter("email"));
			String password = (String)request.getParameter("password");

			User user = userDao.login(userMod.getEmail(), password);
			
			if(user != null) {
				
				session.setAttribute("isLoged", user);
				
				response.sendRedirect(request.getContextPath()+"/"+user.getRole());
			}else {
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
			userMod.setRpassword(request.getParameter("password"));
			
			session.setAttribute("registerUser", userMod);
			response.sendRedirect(contextPath.concat("/register2"));
		}
		
		if(contextPath.concat("/register2").equals(reqURI)) {
			UserRegisterModel userMod = (UserRegisterModel)session.getAttribute("registerUser");
			
			if(userMod != null) {
				// setting up the model for the view
				userMod.setCIN(request.getParameter("cin"));
				userMod.setRbirthday(request.getParameter("birthday"));
				userMod.setRgender(request.getParameter("gender"));
				userMod.setRcity(request.getParameter("city"));
				userMod.setRphone(request.getParameter("phone"));
				userMod.setRbloodType(Integer.parseInt(request.getParameter("bloodType")));
				// creating Donor orbjetc to register User in database
				Donor donor = new Donor(
					userMod.getRfirstName(), 
					userMod.getRlastName(),
					userMod.getRemail(),
					userMod.getRpassword(),
					userMod.getRphone(),
					false
				);
				// registing the user
				User newUser = userDao.register(donor);

				if(newUser != null) {
					//Setting up donor data to add it in database
					donor.setId(newUser.getId());
					donor.setCIN(userMod.getCIN());
					donor.setBirthday(userMod.getRbirthday());
					donor.setGender(userMod.getRgender());
					donor.setCity(userMod.getRcity());
					donor.setBloodid(userMod.getRbloodType());
					
					if(donorDao.create(donor) != null) {
						session.setAttribute("registerUser", null);
						System.out.println("Donor added successfully !");
						response.sendRedirect(contextPath.concat("/login"));
					}else {
						
						System.out.println("Donor faild !");
					}
					
				}else{
				
					System.out.println("User faild !");
				}
				
			}else{
				response.sendRedirect(contextPath.concat("/register"));
			}			
		}
	}
}
