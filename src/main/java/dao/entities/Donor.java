package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.implementation.AppointmentDaoImp;
import dao.implementation.DonorDaoImp;
import dao.implementation.UserDaoImp;
import dao.interfaces.IAppointmentDao;
import dao.interfaces.IDonorDao;
import dao.interfaces.IUserDao; 


public class Donor extends User implements Serializable{
	
	protected Long donorId;
	protected String cin;
	protected String birthDay;
	protected String gender;
	protected String group;
	protected String city;
	protected long zipCode;
	protected String image;
	
	//Associations
	private List<Appointment> appointments = new ArrayList<Appointment>();

	//Dao
	private static IUserDao userDao = new UserDaoImp();
	private static IDonorDao donorDao = new DonorDaoImp();
	private static IAppointmentDao appointDao = new AppointmentDaoImp();
	
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
		this.donorId = Long.parseLong( request.getParameter("id"));
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

	public long getDonorId() {
		return donorId;
	}

	public void setDonorId(long DonorId) {
		this.donorId = DonorId;
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

	public void setBirthDay(String birthDate) {
		this.birthDay = birthDate;
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

	public void setGroup(String group) {
		this.group = group;
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

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
		this.zipCode = zipCode;
	}
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	/*
	 * Business
	 */
	
	public Donor save() {
		try {
			return donorDao.insert(this);			
		}catch(Exception e) {
			return null;
		}
	}
	
	public static Donor update(Donor donor) {
		return donorDao.update(donor);
	}
	

	/**
	 * RelationShips
	 *
	 */
	public User user() {
		return userDao.find(this);
	}
	
	public List<Appointment>appointments(){
		this.appointments = appointDao.find(this);
		return this.appointments;
	}
	
}
