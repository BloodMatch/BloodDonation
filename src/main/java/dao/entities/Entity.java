package dao.entities;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import dao.interfaces.IDao;

public abstract class Entity<TSelf, TDao extends  IDao>{
	
	private long id; 
	
	public abstract void setThis(TSelf t);
	public abstract void setThis(HttpServletRequest request);
	public abstract void setThis(ResultSet rs);
	
	
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public void add() {
		//new TDao
	}
	
	
	public void save() {
		//new TDao
	}
	
	public boolean remove() {
		
		//(new TDao()).delete(this.getId());
		return false;
	}
	
}
