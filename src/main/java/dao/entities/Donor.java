package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest; 


public class Donor extends User implements Serializable{
	
	protected Long donorId;
	protected String cin;
	protected String birthDate;
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
		this.birthDate = birthDate;
		this.gender = gender;
		this.group = group;
		this.city = city;
		this.zipCode = zipCode;
		this.image = image;
	}
	
	public void setThis(Donor donor){
		this.cin = donor.getCin();
		this.birthDate = donor.getBirthDate();
		this.gender = donor.getGender();
		this.group = donor.getGroup();
		this.city = donor.getCity();
		this.zipCode = donor.getZipCode();
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
		this.zipCode = Long.parseLong(request.getParameter("zipCode"));
		this.image = request.getParameter("image");
	}

	public void setThis(ResultSet rs){
		try{
			this.donorId = rs.getLong("id");
			this.cin = rs.getString("cin");
			this.birthDate = rs.getString("birthDate");
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
	
	public void setCenters(List<Center> centers) {
		this.centers= centers;
	}	

	@Override
	public String toString() {
		return "Donor [donorId=" + donorId + ", cin=" + cin + ", birthDay=" + birthDay + ", gender=" + gender
				+ ", group=" + group + ", city=" + city + ", zipCode=" + zipCode + ", image=" + image + "]";
	}
	
}
