package dao.entities;



import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

import dao.DAOFactory;
import dao.interfaces.IEntity;

public class Analysis implements Serializable, IEntity<Analysis>{
	
	private Long id;
	private String code;
	private String date;
	private String comment;
	private AnalysisResults results;
	private long AppointmentId;

	private Appointment appointment;
	
	public Analysis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Analysis( String code, String date, AnalysisResults results, String comment, long AppointmentId) {
		super();
		this.code = code;
		this.date = date;
		this.results = results;
		this.comment = comment;
		this.AppointmentId = AppointmentId;
	}

	public void setThis(Analysis analysis){
		//this.id = analysis.getId();
		this.code = analysis.getCode();
		this.date = analysis.getDate();
		this.results = analysis.getResults();
		this.comment = analysis.getComment();
		this.AppointmentId = analysis.getAppointmentId();
	}

	public void setThis(HttpServletRequest request){
		//this.id = request.getParameter("id");
		this.code = request.getParameter("code");
		this.date = request.getParameter("date");
		this.results = AnalysisResults.fromString( request.getParameter("results"));
		this.comment = request.getParameter("comment");
		this.AppointmentId = Long.parseLong(request.getParameter("AppointmentId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.code = rs.getString("code");
			this.date = rs.getString("date");
			this.results = AnalysisResults.fromString( rs.getString("results"));
			this.comment = rs.getString("comment");
			this.AppointmentId = rs.getLong("AppointmentId");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public AnalysisResults getResults() {
		return results;
	}
	
	public String  getResultsJSON() {
		return results.toString();
	}

	public void setResults(AnalysisResults results) {
		this.results = results;
	}
	
	public void setResultsJSON(String results) {
		this.results = AnalysisResults.fromString(results);
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public long getAppointmentId() {
		return AppointmentId;
	}

	public void setAppointmentId(long AppointmentId) {
		this.AppointmentId = AppointmentId;
	}
	

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	@Override
	public Analysis save() {
		try {
			return DAOFactory.getAnalysisDao().update(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Analysis add() {
		try {
			return DAOFactory.getAnalysisDao().insert(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove() {
		try {
			return DAOFactory.getAnalysisDao().delete(this.id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Analysis [ id=%d, code=%s, date=%s, results=%s, comment=%s, AppointmentId=%d ]",
				id, code, date, results, comment, AppointmentId
			);
	}
	
}
