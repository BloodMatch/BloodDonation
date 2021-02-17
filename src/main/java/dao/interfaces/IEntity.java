package dao.interfaces;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import dao.entities.User;

public interface IEntity<TSelf> {
	public Long getId();
	public void setId(Long id);
	public void setThis(TSelf t);
	public void setThis(HttpServletRequest request);
	public void setThis(ResultSet rs);
	public TSelf save();
	public TSelf add();
	public boolean remove();
}
