package web.controllers.Center;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.DAOFactory;
import dao.entities.Analysis;
import dao.entities.AnalysisResults;
import web.http.ServletController;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/center/analysis"})
public class AnalysisController extends ServletController {
	Analysis analysis;
	
	public void init() throws ServletException {
		super.init();

		//appointmentDao = new AppointmentDaoImp();
		
		router.setBaseURL("/center/analysis");
		router.post("@save", "save");	
	}
	
	public void save() {
		analysis =  DAOFactory.getAnalysisDao().find( Long.parseLong(req.getParameter("id")));
		
		String code = req.getParameter("code");
		String date = req.getParameter("date");
		String group = req.getParameter("group");
		String comment = req.getParameter("comment");
		
		analysis.setCode(code);
		analysis.setDate(date);
		analysis.setComment(comment);

		AnalysisResults results = new AnalysisResults(req);
		
		analysis.setResults(results);
		
		analysis.save();
		
		redirectPrevious();
	}
}
