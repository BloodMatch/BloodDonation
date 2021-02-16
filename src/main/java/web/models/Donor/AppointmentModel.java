package web.models.Donor;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.entities.Appointment;
import dao.entities.Center;
import web.models.Model;

public class AppointmentModel implements Model<Appointment>{
	private long id;
	private String state;
	private String donationType;
	private String time;
	private int satisfaction;
	private String comment;
	private long CenterId;
	private long DonorId;
	private long daysLeft;
	
	
	// Helpers for data binding
	private List<Center> availableCenters = new ArrayList<Center>();
	private List<String> citiesInput = new ArrayList<String>();
	private String dateFiltredInput = "";
	private List<Appointment> appointments = new ArrayList<Appointment>();
	private String donationTInput = "";
	

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
	
	public void clone(Appointment ap) {
		this.id = ap.getCenterId();
		this.state = ap.getState();
		this.donationType = ap.getDonationType();
		this.time = ap.getTime();
		this.satisfaction = ap.getSatisfaction();
		this.comment = ap.getComment();
		this.CenterId = ap.getCenterId();
		this.DonorId = ap.getDonorId();	
	}
	
	private Long subDate(String from, String to) {
		LocalDate d1 = LocalDate.parse(from, DateTimeFormatter.ISO_LOCAL_DATE);
		LocalDate d2 = LocalDate.parse(to, DateTimeFormatter.ISO_LOCAL_DATE);
		Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
		return diff.toDays();
	}
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void setDaysLeft(long daysLeft) {
		this.daysLeft = daysLeft;
	}

	public long getDaysLeft() {
		return daysLeft;
	}

	public void setDaysLeft(String currentDate) {
		this.daysLeft = this.subDate(currentDate, this.time.split(" ")[0]); // Get the date only
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

	public String getDateFiltredInput() {
		return dateFiltredInput;
	}
	
	public void setDateFiltredInput(String date) {
		this.dateFiltredInput = date;
	}
	
	public List<Center> getAvailableCenters() {
		return availableCenters;
	}

	public void setAvailableCenters(List<Center> availableCenters) {
		this.availableCenters = availableCenters;
	}

	public List<String> getCitiesInput() {
		return citiesInput;
	}

	public void setCitiesInput(List<String> cities) {
		this.citiesInput = cities;
	}

	public String getDonationTInput() {
		return donationTInput;
	}

	public void setDonationTInput(String donationT) {
		this.donationTInput = donationT;
	}
	
}
