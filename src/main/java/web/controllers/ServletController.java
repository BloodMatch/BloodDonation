package web.controllers;

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

	protected void view(String src) {
		try {
			req.getRequestDispatcher("/views/" + src + ".view.jsp").forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		router.handleGET(this);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.set(request, response);
		router.handlePOST(this);
	}

}
