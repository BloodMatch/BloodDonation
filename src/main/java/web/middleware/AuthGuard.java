package web.middleware;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.entities.User;

/**
 * Servlet Filter implementation class AuthGuard
 */
public class AuthGuard implements Filter {

	User user;
	ServletRequest req;
	ServletResponse res; 
	FilterChain chain;
	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		this.req =  request;
		this.res =  response;
		this.chain = chain;
		
		HttpSession session = ((HttpServletRequest) req).getSession();
		this.user = (User)session.getAttribute("isLoged");
		
		if( this.user == null ) {
			System.out.println("not loged in yetoto!");
			throw new ServletException();
			//resp.sendRedirect(req.getContextPath()+"/login");
		}
		
	}

	
	protected void checkRole(String role) throws IOException, ServletException {
		if(this.user.getRole().equals(role)) {
			System.out.println("Access authorised");
			chain.doFilter(req, res);			
		}else {
			// last vidited page
			req.setAttribute("back", ((HttpServletRequest) req).getHeader("Referer"));
			req.getRequestDispatcher("accessDenied.jsp").forward(req, res);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
