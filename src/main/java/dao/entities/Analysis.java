package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

public class Analysis implements Serializable{
	
	private long id;
	private long code;
	private String date;
	private String results;
	private String comment;
	private long AppointmentId;


	public Analysis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Analysis( long code, String date, String results, String comment, long AppointmentId) {
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
		this.code = Long.parseLong(request.getParameter("code"));
		this.date = request.getParameter("date");
		this.results = request.getParameter("results");
		this.comment = request.getParameter("comment");
		this.AppointmentId = Long.parseLong(request.getParameter("AppointmentId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.code = rs.getLong("code");
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

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
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

	@Override
	public String toString() {
		return "Donor [ id=" + id+ ", code=" + code+", date="+date+", results="+results+", comment="+comment+", AppointmentId="+AppointmentId+" ]";
	}
	
}
