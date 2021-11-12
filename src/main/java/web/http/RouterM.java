package web.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class RouterM {
	private String basePath = "", groupPath = "";
	private Map<String , Runnable> mapGET;
	private Map<String , Runnable> mapPOST;
	private ServletController servletController;
	
	public RouterM() {
		mapGET = new HashMap<String , Runnable>();
		mapPOST = new HashMap<String , Runnable>();
	}

	public RouterM(ServletController servletController) {
		this();
		this.servletController = servletController;
	}
	
	public RouterM(String basePath) {
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
	
	private void run() {
		
	}
	
	public void get(String url, String  methodName) {
		Method method;
		try {
			method = servletController.getClass().getMethod( methodName);
			///String[] listParam = urlPattern.substring(urlPattern.indexOf("?") + 1 , urlPattern.length()).split(",");
				get( url, ()-> {
				try {
					method.invoke(servletController );
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} );
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
