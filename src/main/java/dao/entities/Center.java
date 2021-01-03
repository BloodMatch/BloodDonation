package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

public class Center implements Serializable{
	
	private long id;
	private String code;
	private String name;
	private String email;
	private String phone1;
	private String phone2;
	private String address;
	private String commune;
	private String province;
	private String region;

	public Center() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Center( String code, String name, String email, String phone1, String phone2, String address, String commune, String province, String region) {
		super();
		this.code = code;
		this.name = name;
		this.email = email;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.address = address;
		this.commune = commune;
		this.province = province;
		this.region = region;
	}

	public void setThis(Center center){
		//this.id = center.getId();
		this.code = center.getCode();
		this.name = center.getName();
		this.email = center.getEmail();
		this.phone1 = center.getPhone1();
		this.phone2 = center.getPhone2();
		this.address = center.getAddress();
		this.commune = center.getCommune();
		this.province = center.getProvince();
		this.region = center.getRegion();
	}

	public void setThis(HttpServletRequest request){
		//this.id = request.getParameter("id");
		this.code = request.getParameter("code");
		this.name = request.getParameter("name");
		this.email = request.getParameter("email");
		this.phone1 = request.getParameter("phone1");
		this.phone2 = request.getParameter("phone2");
		this.address = request.getParameter("address");
		this.commune = request.getParameter("commune");
		this.province = request.getParameter("province");
		this.region = request.getParameter("region");
	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.code = rs.getString("code");
			this.name = rs.getString("name");
			this.email = rs.getString("email");
			this.phone1 = rs.getString("phone1");
			this.phone2 = rs.getString("phone2");
			this.address = rs.getString("address");
			this.commune = rs.getString("commune");
			this.province = rs.getString("province");
			this.region = rs.getString("region");
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

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Donor [ id=" + id+ ", code=" + code+", name="+name+", email="+email+", phone1="+phone1+", phone2="+phone2+" ]";
	}
	
}
