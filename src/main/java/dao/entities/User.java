package dao.entities;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import business.Hash;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
 

public class User implements Serializable{
	
	protected long id;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String passwd;
	protected String phone;
	protected Boolean active;
	protected String role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName, String email, String passwd, String phone, Boolean active, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = Hash.makeHash(password);
		this.phone = phone;
		this.active = active;
		this.role = role;
	}

	public void setThis(User user){
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.passwd = user.getPasswd();
		this.phone = user.getPhone();
		this.active = user.getActive();
		this.role = user.getRole();
	}

	public void setThis(HttpServletRequest request){
		this.firstName = request.getParameter("firstName");
		this.lastName = request.getParameter("lastName");
		this.email = request.getParameter("email");
		this.passwd = request.getParameter("passwd");
		this.phone = request.getParameter("phone");
		this.active = Boolean.parseBoolean(request.getParameter("active"));
		this.role = request.getParameter("role");
	}

	public void setThis(ResultSet rs){
		try {
			this.id = rs.getLong("id");
			this.firstName = rs.getString("firstName");
			this.lastName = rs.getString("lastName");
			this.email = rs.getString("email");
			this.passwd = rs.getString("passwd");
			this.phone = rs.getString("phone");
			this.active = rs.getBoolean("active");
			this.role = rs.getString("role");
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", passwd=" + passwd + ", phone=" + phone + ", active=" + active + ", role=" + role + "]";
	}
	
}
