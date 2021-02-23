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

import dao.entities.Appointment;
import dao.entities.Donor;
import dao.entities.User;

public class CanSchedule implements Filter {

    public CanSchedule() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("isLoged");
		Donor donor = user.donor();
		
		if(donor.getTested() ) {
			Appointment appoint =Appointment.lastDonation(donor.getDonorId());
			System.out.println(appoint.getState());
			if(appoint != null) {
				Long duration = appoint.duration();
				if( (appoint.getDonationType().equals("AB Plasma") && duration <= 28) ||
					(appoint.getDonationType().equals("Platelets") && duration <= 7)  ||
					(appoint.getDonationType().equals("Power Red") && duration <= 112) ||
					(appoint.getDonationType().equals("Blood") && duration <= 56)){
					resp.sendRedirect(req.getContextPath()+"/donor/menu?access=false");
					return;
				}
			}
			chain.doFilter(request, response);
		}else {
			resp.sendRedirect(req.getContextPath()+"/donor/requirements");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
