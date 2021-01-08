package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

public class Appointment implements Serializable{
	
	private long id;
	private String state;
	private String date;
	private int satisfaction;
	private String comment;
	private String DonorCin;
	private long CenterId;


	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment( String state, String date, int satisfaction, String comment, String DonorCin, long CenterId) {
		super();
		this.state = state;
		this.date = date;
		this.satisfaction = satisfaction;
		this.comment = comment;
		this.DonorCin = DonorCin;
		this.CenterId = CenterId;
	}

	public void setThis(Appointment appointment){
		//this.id = appointment.getId();
		this.state = appointment.getState();
		this.date = appointment.getDate();
		this.satisfaction = appointment.getSatisfaction();
		this.comment = appointment.getComment();
		this.DonorCin = appointment.getDonorCin();
		this.CenterId = appointment.getCenterId();
	}

	public void setThis(HttpServletRequest request){
		//this.id = request.getParameter("id");
		this.state = request.getParameter("state");
		this.date = request.getParameter("date");
		this.satisfaction = Integer.parseInt( request.getParameter("satisfaction"));
		this.comment = request.getParameter("comment");
		this.DonorCin = request.getParameter("DonorCin");
		this.CenterId = Long.parseLong(request.getParameter("CenterId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.state = rs.getString("state");
			this.date = rs.getString("date");
			this.satisfaction = rs.getInt("satisfaction");
			this.comment = rs.getString("comment");
			this.DonorCin = rs.getString("DonorCin");
			this.CenterId = rs.getLong("CenterId");
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDonorCin() {
		return DonorCin;
	}

	public void setDonorCin(String DonorCin) {
		this.DonorCin = DonorCin;
	}
	
	public long getCenterId() {
		return CenterId;
	}

	public void setCenterId(long CenterId) {
		this.CenterId = CenterId;
	}

	@Override
	public String toString() {
		return "Donor [ id=" + id+ ", state=" + state+", date="+date+", satisfaction="+satisfaction+", comment="+comment+", DonorCin="+DonorCin+", CenterId="+CenterId+" ]";
	}
	
}
