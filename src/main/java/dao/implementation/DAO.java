package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.Analysis;
import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;
import dao.entities.Entity;
import dao.interfaces.IAppointmentDao;
import dao.interfaces.IDao;

public abstract class DAO <T extends Entity<?,?>>  implements IDao<T>{
	private final static Connection connection = DbConnection.getConnection();
	private String table;
	
	public abstract T getEntity();

	public T find(long id) {
		T bean= null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM "+table+" WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bean = getEntity();
				bean.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public List<T> findAll() {
		List<T> beans = new ArrayList<T>();
		
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM "+table);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				T bean = getEntity();
				bean.setThis(rs);
				beans.add(bean);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM "+table+" WHERE id=?");
			ps.setLong(1, id);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * RELATIONSHIPS
	 * */
	
}
