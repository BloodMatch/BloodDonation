package dao.entities;

import java.io.Serializable;
 

public class Blood implements Serializable{
	
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
