package web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;

public class Router {
	private String basePath = "", groupPath = "";
	private Map<String , Runnable> mapGET;
	private Map<String , Runnable> mapPOST;
	
	public Router() {
		mapGET = new HashMap<String , Runnable>();
		mapPOST = new HashMap<String , Runnable>();
	}

	public Router(String basePath) {
		this();
		this.basePath = basePath;
	}
	
	public void setBaseURL(String url){
		basePath = url;
	}
	
	public void group(String url, Runnable groupRoutes) {
		groupPath = url;
		groupRoutes.run();
		groupPath = "";
	}
	
	public void get(String url, Runnable Action) {
		mapGET.put( basePath + groupPath + url, Action);
	}

	public Runnable get(String url) {
		return mapGET.get(url);
	}

	public void post(String url, Runnable Action) {
		System.out.println("post: "+url);
		mapPOST.put( basePath + groupPath + url, Action);
	}

	public Runnable post(String url) {
		return mapPOST.get( url);
	}
	
	public void handleGET(ServletController serveletCntrl) {
		System.out.println("[GET] : "+serveletCntrl.req.getServletPath());
		mapGET.get(
				serveletCntrl.req.getServletPath() 
			).run();
	}
	
	public void handlePOST(ServletController serveletCntrl) throws NullPointerException{
		System.out.println("[POST] : "+serveletCntrl.req.getServletPath() +"@"+ serveletCntrl.req.getParameter("action"));
		mapPOST.get(
				serveletCntrl.req.getServletPath() +
				"@"+ serveletCntrl.req.getParameter("action") 
			).run();
	}
	
	
}
