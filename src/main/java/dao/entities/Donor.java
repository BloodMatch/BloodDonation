package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest; 


public class Donor extends User implements Serializable{
	
	protected String cin;
	protected String birthDay;
	protected String gender;
	protected String profession;
	protected String city;
	protected String image;
	protected long BloodId;
	
	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donor(String firstName, String lastName, String email, String password, String phone,
			String cin, String birthDay, String gender, String profession, String city, String image, long BloodId) {
		super( firstName, lastName, email, password, phone, false, "Donor");
		this.cin = cin;
		this.birthDay = birthDay;
		this.gender = gender;
		this.profession = profession;
		this.city = city;
		this.image = image;
		this.BloodId = BloodId;
	}
	
	public void setThis(Donor donor){
		this.cin = donor.getCin();
		this.birthDay = donor.getBirthDay();
		this.gender = donor.getGender();
		this.profession = donor.getProfession();
		this.city = donor.getCity();
		this.image = donor.getImage();
		this.BloodId = donor.getBloodId();
	}

	public void setThis(HttpServletRequest request){
		super.setThis(request);
		this.cin = request.getParameter("cin");
		this.birthDay = request.getParameter("birthDay");
		this.gender = request.getParameter("gender");
		this.profession = request.getParameter("profession");
		this.city = request.getParameter("city");
		this.image = request.getParameter("image");
		this.BloodId = Long.parseLong( request.getParameter("BloodId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.cin = rs.getString("cin");
			this.birthDay = rs.getString("birthDay");
			this.gender = rs.getString("gender");
			this.profession = rs.getString("profession");
			this.city = rs.getString("city");
			this.image = rs.getString("image");
			this.id = rs.getLong("userId");
			this.BloodId = rs.getLong("BloodId");
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
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
	
	public long getBloodId() {
		return BloodId;
	}

	public void setBloodId(long BloodId) {
		this.BloodId = BloodId;
	}

	@Override
	public String toString() {
		return "Donor [ cin=" + cin + ", birthDay=" + birthDay + ", gender=" + gender
				+ ", profession="+ profession + ", BloodId=" + BloodId + ", city=" + city + ", image=" + image + " >> "+ super.toString() +"]";
	}
	
}
