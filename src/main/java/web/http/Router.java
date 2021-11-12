package web.http;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Router {
	private String basePath = "", groupPath = "";
	private Map<String , Runnable> mapGET;
	private Map<String , Runnable> mapPOST;
	private ServletController servletController;
	
	
	public Router() {
		mapGET = new HashMap<String , Runnable>();
		mapPOST = new HashMap<String , Runnable>();
	}

	public Router(ServletController servletController) {
		this();
		this.servletController = servletController;
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
	
	public void invoke(String  methodName) {
		try {
			servletController.getClass().getMethod( methodName).invoke( servletController);
		} catch (NoSuchMethodException | SecurityException  | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	public void get(String url, String  methodName){
		get( url, ()-> invoke(methodName));
	}
	
	public void get(String url, Runnable Action) {
		mapGET.put( basePath 	+ groupPath + url, Action);
	}

	public Runnable get(String url) {
		return () -> {mapGET.get(url);};
	}

	public void post(String url, String  methodName){
		post( url, ()-> invoke(methodName));
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
