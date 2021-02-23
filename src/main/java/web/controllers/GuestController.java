package web.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/home","/faq","/about","/contact","/gallery"})
public class GuestController extends ServletController  {
	
	
	public void init() throws ServletException {
		super.init();
	
		router.setBaseURL("");
		router.get("/home", () -> page("guest/home"));
		router.get("/faq", () -> page("guest/faq"));
		router.get("/about", () -> page("guest/about"));
		router.get("/contact", () -> page("guest/contact"));
		router.get("/gallery", () -> page("guest/gallery"));
	}
}
