package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest; 


public class Donor extends User implements Serializable{
	
	protected Long donorId;
	protected String cin;
	protected String birthDay;
	protected String gender;
	protected String group;
	protected String city;
	protected long zipCode;
	protected String image;
	
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Donor (String firstName, String lastName, String email, String password, String phone	) {
		super( firstName, lastName, email, password, phone, false, "donor");
	}

	public Donor(String firstName, String lastName, String email, String password, String phone,
			String cin, String birthDay, String gender, String group, String city, long zipCode, String image) {
		super( firstName, lastName, email, password, phone, false, "donor");
		this.cin = cin;
		this.birthDay = birthDay;
		this.gender = gender;
		this.group = group;
		this.city = city;
		this.zipCode = zipCode;
		this.image = image;
	}
	
	public void setThis(Donor donor){
		this.cin = donor.getCin();
		this.birthDay = donor.getBirthDay();
		this.gender = donor.getGender();
		this.group = donor.getGroup();
		this.city = donor.getCity();
		this.zipCode = donor.getZipCode();
		this.image = donor.getImage();
	}

	public void setThis(HttpServletRequest request){
		super.setThis(request);
		this.cin = request.getParameter("cin");
		this.birthDay = request.getParameter("birthDay");
		this.gender = request.getParameter("gender");
		this.group = request.getParameter("group");
		this.city = request.getParameter("city");
		this.zipCode = Long.parseLong(request.getParameter("zipCode"));
		this.image = request.getParameter("image");
	}

	public void setThis(ResultSet rs){
		try{
			this.donorId = rs.getLong("id");
			this.cin = rs.getString("cin");
			this.birthDay = rs.getString("birthDay");
			this.gender = rs.getString("gender");
			this.group = rs.getString("group");
			this.city = rs.getString("city");
			this.zipCode = rs.getLong("ZIPCode");
			this.image = rs.getString("image");
			this.id = rs.getLong("userId");
			
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getDonorId() {
		return donorId;
	}

	public void setDonorId(Long donorId) {
		this.donorId = donorId;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", cin=" + cin + ", birthDay=" + birthDay + ", gender=" + gender
				+ ", group=" + group + ", city=" + city + ", zipCode=" + zipCode + ", image=" + image + "]";
	}
	
}
