package web.models;

import java.util.ArrayList;
import java.util.List;

import dao.entities.Appointment;
import dao.entities.Center;

public class AppointmentModel {
	private long id;
	private String state;
	private String donationType;
	private String time;
	private int satisfaction;
	private String comment;
	private long CenterId;
	private long DonorId;
	
	private List<Center> availableCenters = new ArrayList<Center>();
	private String dateFiltred = "";
	private List<String> cities = new ArrayList<String>();
	private String donationT = "";
	private Appointment lastAppoint;
	
	public AppointmentModel() {
		
	}
	
	public AppointmentModel(String state, String donationType, String time, int satisfaction, String comment,
			long centerId, long donorId) {
		super();
		this.state = state;
		this.donationType = donationType;
		this.time = time;
		this.satisfaction = satisfaction;
		this.comment = comment;
		CenterId = centerId;
		DonorId = donorId;
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

	public long getCenterId() {
		return CenterId;
	}

	public void setCenterId(long centerId) {
		CenterId = centerId;
	}

	public long getDonorId() {
		return DonorId;
	}

	public void setDonorId(long donorId) {
		DonorId = donorId;
	}

	public String getDateFiltred() {
		return dateFiltred;
	}
	
	public void setDateFiltred(String date) {
		this.dateFiltred = date;
	}
	
	public List<Center> getAvailableCenters() {
		return availableCenters;
	}

	public void setAvailableCenters(List<Center> availableCenters) {
		this.availableCenters = availableCenters;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public String getDonationT() {
		return donationT;
	}

	public void setDonationT(String donationT) {
		this.donationT = donationT;
	}
	
	

	public Appointment getLastAppoint() {
		return lastAppoint;
	}

	public void setLastAppoint(Appointment lastAppoint) {
		this.lastAppoint = lastAppoint;
	}

	@Override
	public String toString() {
		return "AppointmentModel [id=" + id + ", state=" + state + ", donationType=" + donationType + ", time=" + time
				+ ", satisfaction=" + satisfaction + ", comment=" + comment + ", CenterId=" + CenterId + ", DonorId="
				+ DonorId + "]";
	}
	
}
