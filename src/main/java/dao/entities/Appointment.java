package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Appointment implements Serializable{
	
	private long id;
	private String state;
	private String donationType;
	private String time;
	private int satisfaction;
	private String comment;
	private long CenterId;
	private long DonorId;
	
	private Donor donor;
	private Center center;
	private Analysis analysis; 


	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment( String state, String donationType, String time, int satisfaction, String comment, long DonorId, long CenterId) {
		super();
		this.state = state;
		this.donationType = donationType;
		this.time = time;
		this.satisfaction = satisfaction;
		this.comment = comment;
		this.DonorId = DonorId;
		this.CenterId = CenterId;
	}

	public void setThis(Appointment appointment){
		//this.id = appointment.getId();
		this.state = appointment.getState();
		this.donationType = appointment.getDonationType();
		this.time = appointment.getTime();
		this.satisfaction = appointment.getSatisfaction();
		this.comment = appointment.getComment();
		this.DonorId = appointment.getDonorId();
		this.CenterId = appointment.getCenterId();
	}

	public void setThis(HttpServletRequest request){
		//this.id = request.getParameter("id");
		this.state = request.getParameter("state");
		this.state = request.getParameter("donationType");
		this.time = request.getParameter("time");
		this.satisfaction = Integer.parseInt( request.getParameter("satisfaction"));
		this.comment = request.getParameter("comment");
		this.DonorId = Long.parseLong( request.getParameter("DonorId"));
		this.CenterId = Long.parseLong(request.getParameter("CenterId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.state = rs.getString("state");
			this.donationType = rs.getString("donationType");
			this.time = rs.getString("time");
			this.satisfaction = rs.getInt("satisfaction");
			this.comment = rs.getString("comment");
			this.DonorId = rs.getLong("DonorId");
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

	public String getDonationType() {
		return donationType;
	}

	public void setDonationType(String donationType) {
		this.donationType = donationType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public long getDonorId() {
		return DonorId;
	}

	public void setDonorId(long DonorId) {
		this.DonorId = DonorId;
	}
	
	public long getCenterId() {
		return CenterId;
	}

	public void setCenterId(long CenterId) {
		this.CenterId = CenterId;
	}
	
	
	public Donor getDonor(){
		return donor;
	}
	
	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Center getCenter(){
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	
	public Analysis getAnalysis(){
		return analysis;
	}

	public void setAnalysis(Analysis analysis) {
		this.analysis = analysis;
	}
	
	@Override
	public String toString() {
		return String.format(
			"Appointment [ id=%d, state=%s, donationType=%s, time=%s, comment=%s, DonorId=%d, CenterId  =%d]",
				id, state, donationType, time, comment, DonorId, CenterId
		);
	}
	
}
