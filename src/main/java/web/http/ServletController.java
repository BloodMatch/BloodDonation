package web.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ServletController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest req;
	protected HttpServletResponse res;
	private String path = "";
	protected Router router;

	private void set(HttpServletRequest request, HttpServletResponse response) {
		this.req = request;
		this.res = response;
	}

	protected void page(String src) {
		try {
			req.getRequestDispatcher("/views/" + src + ".jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void view(String src) {
		page( src + ".view");
	}

	protected void servlet(String servlet) {
		redirect(req.getContextPath().concat(servlet));
	}

	protected void redirect(String href) {
		try {
			res.sendRedirect(href);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void redirectPrevious() {
		redirect(req.getHeader("referer"));
	}

	protected String getPath() {
		return path;
	}

	@Override
	public void init() throws ServletException {
		router = new Router(this);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.set(request, response);
		/*System.out.println("getServletPath : "+req.getServletPath());
		System.out.println("getContextPath : "+req.getContextPath());
		System.out.println("getPathInfo : "+req.getPathInfo());*/
		try {
			router.handleGET(this);
			
		}  catch (NullPointerException e) { //page note found
			page("/error404");
			//servlet("/error404");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.set(request, response);
		router.handlePOST(this);
	}

}
