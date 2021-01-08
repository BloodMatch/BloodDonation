package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
 

public class Bag implements Serializable{
	
	private long id;
	private String type;
	private String group;
	private String description;
	private long saftyStore;

	
	public Bag() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bag(String type,String group, String description, long saftyStore) {
		super();
		this.type = type;
		this.group = group;
		this.description = description;
		this.saftyStore = saftyStore;
	}

	public void setThis(Bag blood){
		//this.id = blood.getId();
		this.type = blood.getType();
		this.group = blood.getGroup();
		this.description = blood.getDescription();
		this.saftyStore = blood.getSaftyStore();
	}

	public void setThis(HttpServletRequest request){
		this.id = Long.parseLong( request.getParameter("id"));
		this.type = request.getParameter("type");
		this.group = request.getParameter("group");
		this.description = request.getParameter("description");
		this.saftyStore = Long.parseLong( request.getParameter("saftyStore"));
	}

	public void setThis(ResultSet rs){
		try{
			this.id= rs.getLong("id");
			this.type = rs.getString("type");
			this.group = rs.getString("group");
			this.description = rs.getString("description");
			this.saftyStore = rs.getLong("saftyStore");
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
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getSaftyStore() {
		return saftyStore;
	}

	public void setSaftyStore(long saftyStore) {
		this.saftyStore = saftyStore;
	}

	@Override
	public String toString() {
		return String.format(
				"Bag [ id=%d, type=%s, group=%s, description=%s, saftyStore=%d]", 
				id, type, group, description, saftyStore
			);
	}
	
}
