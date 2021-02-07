package dao.entities;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import dao.interfaces.IDao;

public abstract class Entity<TSelf, TDao extends  IDao>{
	
	protected TDao  idao;
	protected long id;
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
		idao.insert( this);
	}
	
	
	public void save() {
		idao.update( this);
	}
	
	public boolean remove() {
		return idao.delete( this.getId());
	}
	
}
