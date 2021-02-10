package dao.interfaces;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import dao.entities.User;

public interface IEntity<TSelf> {
	public long getId();
	public void setId(long id);
	public abstract void setThis(TSelf t);
	public abstract void setThis(HttpServletRequest request);
	public abstract void setThis(ResultSet rs);
}
