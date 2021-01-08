package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest; 


public class Donor extends User implements Serializable{
	
	protected long DonorId;
	protected String cin;
	protected String birthDate;
	protected String gender;
	protected String group;
	protected String city;
	protected long ZIPCode;
	protected String image;
	
	protected List<Appointment> appointments;
	protected List<Center> centers;
	
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donor(String firstName, String lastName, String email, String password, String phone,
			String cin, String birthDate, String gender, String group, String city, long ZIPCode) {
		super( firstName, lastName, email, password, phone, false, "Donor");
		this.cin = cin;
		this.birthDate = birthDate;
		this.gender = gender;
		this.group = group;
		this.city = city;
		this.ZIPCode = ZIPCode;
		this.image = image;
	}
	
	public void setThis(Donor donor){
		this.cin = donor.getCin();
		this.birthDate = donor.getBirthDate();
		this.gender = donor.getGender();
		this.group = donor.getGroup();
		this.city = donor.getCity();
		this.ZIPCode = donor.getZIPCode();
		this.image = donor.getImage();
	}

	public void setThis(HttpServletRequest request){
		super.setThis(request);
		this.DonorId = Long.parseLong( request.getParameter("id"));
		this.cin = request.getParameter("cin");
		this.birthDate = request.getParameter("birthDate");
		this.gender = request.getParameter("gender");
		this.group = request.getParameter("group");
		this.city = request.getParameter("city");
		this.ZIPCode = Long.parseLong( request.getParameter("ZIPCode"));
		this.image = request.getParameter("image");
		
	}

	public void setThis(ResultSet rs){
		try{
			this.DonorId = rs.getLong("id");
			this.cin = rs.getString("cin");
			this.birthDate = rs.getString("birthDate");
			this.gender = rs.getString("gender");
			this.group = rs.getString("group");
			this.city = rs.getString("city");
			this.ZIPCode = rs.getLong("ZIPCode");
			this.image = rs.getString("image");
			this.id = rs.getLong("userId");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	public long getDonorId() {
		return DonorId;
	}

	public void setDonorId(long DonorId) {
		this.DonorId = DonorId;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDay(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGroup() {
		return group;
	}

	public void setProfession(String group) {
		this.group = group;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public long getZIPCode() {
		return ZIPCode;
	}

	public void setZIPCode(long ZIPCode) {
		this.ZIPCode = ZIPCode;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	public List<Appointment> getAppointments() {
		return appointments;
	}
	
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}	
	
	public List<Center> getCenters() {
		return centers;
	}
	
	public void setCenters(List<Center> centers) {
		this.centers= centers;
	}	

	@Override
	public String toString() {
		return String.format(
			"Donor [ DonorId=%d, cin=%s, birthDate=%s, gender=%s, group=%s, city=%s, ZIPCode=%d, image=%s >> %s ]",
				DonorId, cin, birthDate, gender, group, city, ZIPCode, image, super.toString()
		);
	}
	
}
