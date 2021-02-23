package dao.entities;

import java.io.Serializable;
import com.google.gson.Gson;
import javax.servlet.http.HttpServletRequest;


@SuppressWarnings("serial")
public class AnalysisResults implements Serializable {
	private static Gson gson = new Gson();
	public String index1;
	public String index2;
	public String index3;
	public String index4;
	public String index5;
	public String index6;
	
	public AnalysisResults() {
		
	}
	
	public AnalysisResults(HttpServletRequest request) {
		this.index1 = request.getParameter("index1");
		this.index2 = request.getParameter("index2");
		this.index3 = request.getParameter("index3");
		this.index4 = request.getParameter("index4");
		this.index5 = request.getParameter("index5");
		this.index6 = request.getParameter("index6");
	}
	
	@Override
	public String toString() {
		return gson.toJson(this);
	}
	
	public static AnalysisResults fromString(String string) {
		return gson.fromJson( string,  AnalysisResults.class);
	}
}
