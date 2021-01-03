package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest; 


public class AdminCenter extends User implements Serializable{
	
	protected String matricule;
	protected long CenterId;
	
	public AdminCenter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminCenter(String firstName, String lastName, String email, String password, String phone,
			String matricule, long CenterId) {
		super( firstName, lastName, email, password, phone, false, "AdminCenter");
		this.matricule = matricule;
		this.CenterId = CenterId;
	}
	
	public void setThis(AdminCenter donor){
		this.matricule = donor.getMatricule();
		this.CenterId = donor.getCenterId();
	}

	public void setThis(HttpServletRequest request){
		super.setThis(request);
		this.matricule = request.getParameter("matricule");
		this.CenterId = Long.parseLong( request.getParameter("CenterId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.matricule = rs.getString("matricule");
			this.CenterId = rs.getLong("CenterId");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public long getCenterId() {
		return CenterId;
	}

	public void setCenterId(long CenterId) {
		this.CenterId = CenterId;
	}

	@Override
	public String toString() {
		return "AdminCenter [ matricule=" + matricule + ", CenterId=" + CenterId + " >> "+ super.toString() +"]";
	}
	
}
