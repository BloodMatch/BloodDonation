package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 

public class Blood implements Serializable{
	
	private long id;
	private String type;
	private String description;
	
	public Blood() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Blood(String type, String description) {
		super();
		this.type = type;
		this.description = description;
	}

	public void setThis(Blood blood){
		//this.id = blood.getId();
		this.type = blood.getType();
		this.description = blood.getDescription();
	}

	public void setThis(ResultSet rs){
		try{
			this.type = rs.getString("type");
			this.description = rs.getString("description");
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Donor [ type=" + type+ ", description=" + description +" ]";
	}
	
}
