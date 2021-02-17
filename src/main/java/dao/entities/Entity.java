package dao.entities;

import dao.interfaces.IDao;
import dao.interfaces.IEntity;

public abstract class Entity<TSelf, TDao extends IDao> implements IEntity<TSelf>{
	/*
	 * TDao : AppointmentDaoImp implements IAppointmentDao
	 * IDao :  
	 * */
	protected static IDao idao;
	protected long id;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public TSelf add() {
		return (TSelf)idao.insert(this);
	}
	
	public TSelf save() {
		return (TSelf)idao.update( this);
	}
	
	public boolean remove() {
		return idao.delete( this.getId());
	}
	
}
