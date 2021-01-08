package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

public class Stock implements Serializable{
	
	private long id;
	private long quantity;
	private Boolean required;
	private long CenterId;
	private long BagId;


	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock( long quantity, Boolean required, long CenterId, long BagId) {
		super();
		this.quantity = quantity;
		this.required = required;
		this.CenterId = CenterId;
		this.BagId = BagId;
	}

	public void setThis(Stock bag){
		//this.id = bag.getId();
		this.quantity = bag.getQuantity();
		this.required = bag.getRequired();
		this.CenterId = bag.getCenterId();
		this.BagId = bag.getBagId();
	}

	public void setThis(HttpServletRequest request){
		//this.id = request.getParameter("id");
		this.quantity = Long.parseLong(request.getParameter("quantity"));
		this.required = Boolean.parseBoolean(request.getParameter("required"));
		this.CenterId = Long.parseLong(request.getParameter("CenterId"));
		this.BagId = Long.parseLong(request.getParameter("BagId"));

	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.quantity = rs.getLong("quantity");
			this.required = rs.getBoolean("required");
			this.CenterId = rs.getLong("CenterId");
			this.BagId = rs.getLong("BagId");

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

	public long getBagId() {
		return BagId;
	}

	public void setBagId(long BagId) {
		this.BagId = BagId;
	}

	@Override
	public String toString() {
		return "Stock [ id=" + id+ ", quantity=" + quantity+", required="+required+", CenterId="+CenterId+", BagId="+BagId+" ]";
	}
	
}
