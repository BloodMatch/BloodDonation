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


public class IsAdminCenter extends AuthGuard {

   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			super.doFilter(request, response, chain);
			checkRole("center");
			
		} catch (ServletException e) {
			// TODO: handle exception
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath()+"/login");
		}
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
