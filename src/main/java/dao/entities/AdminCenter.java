package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest; 
import dao.DAOFactory;

public class AdminCenter extends User implements Serializable{
	
	protected long AdminCenterId;
	protected String matricule;
	protected long CenterId;
	
	protected Center center;
	
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
		this.AdminCenterId = donor.getAdminCenterId();
		this.matricule = donor.getMatricule();
		this.CenterId = donor.getCenterId();
	}

	public void setThis(HttpServletRequest request){
		super.setThis(request);
		this.AdminCenterId = Long.parseLong( request.getParameter("id"));
		this.matricule = request.getParameter("matricule");
		this.CenterId = Long.parseLong( request.getParameter("CenterId"));
	}

	public void setThis(ResultSet rs){
		try{
			this.AdminCenterId = rs.getLong("id");
			this.matricule = rs.getString("matricule");
			this.CenterId = rs.getLong("CenterId");
			this.id = rs.getLong("userId");
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	public long getAdminCenterId() {
		return AdminCenterId;
	}

	public void setAdminCenterId(long AdminCenterId) {
		this.AdminCenterId = AdminCenterId;
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
	
	public Center getCenter() {
		return center;
	}
	
	public void setCenter() {
		this.center = DAOFactory.getCenterDao().find(this);
	}
	
	public void setCenter(Center center) {
		this.center = center;
	}
	
	@Override
	public String toString() {
		return String.format(
			"AdminCenter [ AdminCenterId=%d, matricule=%s, CenterId=%d >> %s ]",
				AdminCenterId, matricule, CenterId, super.toString()
		);
	}
	
}
