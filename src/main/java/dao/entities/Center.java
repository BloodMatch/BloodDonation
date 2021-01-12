package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Center implements Serializable{
	
	private long id;
	private String code;
	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String city;
	private String address;
	private long ZIPCode;

	protected List<Appointment> appointments;
	protected List<AdminCenter> adminCenters;
	protected List<Stock> stocks;
	
	public Center() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Center( String code, String name, String email, String phone1, String phone2, String city, String address, long ZIPCode) {
		super();
		this.code = code;
		this.name = name;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.city = city;
		this.address = address;
		this.ZIPCode = ZIPCode;
	}

	public void setThis(Center center){
		//this.id = center.getId();
		this.code = center.getCode();
		this.name = center.getName();
		this.email = center.getEmail();
		this.phone1 = center.getPhone1();
		this.phone2 = center.getPhone2();
		this.city = center.getCity();
		this.address = center.getAddress();
		this.ZIPCode = center.getZIPCode();
	}

	public void setThis(HttpServletRequest request){
		//this.id = Long.parseLong( request.getParameter("id"));
		this.code = request.getParameter("code");
		this.name = request.getParameter("name");
		this.email = request.getParameter("email");
		this.phone1 = request.getParameter("phone1");
		this.phone2 = request.getParameter("phone2");
		this.city = request.getParameter("city");
		this.address = request.getParameter("address");
		this.ZIPCode = Long.parseLong( request.getParameter("ZIPCode"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.code = rs.getString("code");
			this.name = rs.getString("name");
			this.email = rs.getString("email");
			this.phone1 = rs.getString("phone1");
			this.phone2 = rs.getString("phone2");
			this.city = rs.getString("city");
			this.address = rs.getString("address");
			this.ZIPCode = rs.getLong("ZIPCode");
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	
	public List<Appointment> getAppointments() {
		return appointments;
	}
	
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public List<AdminCenter> getAdminCenters() {
		return adminCenters;
	}
	
	public void setAdminCenters(List<AdminCenter> adminCenters) {
		this.adminCenters = adminCenters;
	}
	

	public List<Stock> getStocks() {
		return stocks;
	}
	
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Center [ id=%d, code=%s, name=%s, email=%s, phone1=%s, phone2=%s, city=%s, address=%s, ZIPCode=%d ]",
				id, code, name, email, phone1, phone2, city, address, ZIPCode
			);
	}
}
