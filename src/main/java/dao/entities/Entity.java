package dao.entities;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import dao.interfaces.IDao;
import dao.interfaces.IEntity;

public abstract class Entity<TSelf, TDao extends  IDao> implements IEntity<TSelf>{
	
	protected TDao  idao;
	protected long id;
	
	
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
