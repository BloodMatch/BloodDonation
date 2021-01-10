package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

public class Analysis implements Serializable{
	
	private long id;
	private String code;
	private String date;
	private String results;
	private String comment;
	private long AppointmentId;

	private Appointment appointment;
	
	public Analysis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Analysis( String code, String date, String results, String comment, long AppointmentId) {
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
		this.results = request.getParameter("results");
		this.comment = request.getParameter("comment");
		this.AppointmentId = Long.parseLong(request.getParameter("AppointmentId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.code = rs.getString("code");
			this.date = rs.getString("date");
			this.results = rs.getString("results");
			this.comment = rs.getString("comment");
			this.AppointmentId = rs.getLong("AppointmentId");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public String getResults() {
		return results;
	}

	public void setResults(String results) {
		this.results = results;
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
	public String toString() {
		return String.format(
				"Analysis [ id=%d, code=%s, date=%s, results=%s, comment=%s, AppointmentId=%d ]",
				id, code, date, results, comment, AppointmentId
			);
	}
	
}
