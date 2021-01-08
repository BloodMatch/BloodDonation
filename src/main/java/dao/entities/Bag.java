package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

public class Bag implements Serializable{
	
	private long id;
	private long quantity;
	private Boolean required;
	private long CenterId;
	private long BloodId;


	public Bag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bag( long quantity, Boolean required, long CenterId, long BloodId) {
		super();
		this.quantity = quantity;
		this.required = required;
		this.CenterId = CenterId;
		this.BloodId = BloodId;
	}

	public void setThis(Bag bag){
		//this.id = bag.getId();
		this.quantity = bag.getQuantity();
		this.required = bag.getRequired();
		this.CenterId = bag.getCenterId();
		this.BloodId = bag.getBloodId();
	}

	public void setThis(HttpServletRequest request){
		//this.id = request.getParameter("id");
		this.quantity = Long.parseLong(request.getParameter("quantity"));
		this.required = Boolean.parseBoolean(request.getParameter("required"));
		this.CenterId = Long.parseLong(request.getParameter("CenterId"));
		this.BloodId = Long.parseLong(request.getParameter("BloodId"));

	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.quantity = rs.getLong("quantity");
			this.required = rs.getBoolean("required");
			this.CenterId = rs.getLong("CenterId");
			this.BloodId = rs.getLong("BloodId");

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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public long getCenterId() {
		return CenterId;
	}

	public void seCenterId(long CenterId) {
		this.CenterId = CenterId;
	}

	public long getBloodId() {
		return BloodId;
	}

	public void setBloodId(long BloodId) {
		this.BloodId = BloodId;
	}

	@Override
	public String toString() {
		return "Donor [ id=" + id+ ", quantity=" + quantity+", required="+required+", CenterId="+CenterId+", BloodId="+BloodId+" ]";
	}
	
}
