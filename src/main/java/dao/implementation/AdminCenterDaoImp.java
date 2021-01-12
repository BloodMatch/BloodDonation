package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.AdminCenter;
import dao.entities.Center;
import dao.entities.User;
import dao.interfaces.IAdminCenterDao;

public class AdminCenterDaoImp extends UserDaoImp implements IAdminCenterDao{
	private final static Connection connection = DbConnection.getConnection();

	public AdminCenter insert(AdminCenter admincenter) {
		try {
			
			super.register(admincenter);
			
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO ADMINCENTER( MATRICULE, CENTERID, USERID) VALUES(?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, admincenter.getMatricule());
			ps.setLong(2, admincenter.getCenterId());
			ps.setLong(3, admincenter.getId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				admincenter.setAdminCenterId(rs.getInt(1));
				return admincenter;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public AdminCenter find(long id) {
		AdminCenter admincenter = null;
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM ADMINCENTER WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admincenter = new AdminCenter();
				admincenter.setThis(rs);
				
				user = super.find( admincenter.getId());
				admincenter.setThis(user);
				
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admincenter;
	}
	
	public List<User> findAll() {
		List<User> admincenters = new ArrayList<User>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM ADMINCENTER");
			ResultSet rs = ps.executeQuery();
			AdminCenter admincenter;
			User user;
			while(rs.next()) {
				admincenter = new AdminCenter();
				admincenter.setThis(rs);
				
				user = super.find(admincenter.getId() );
				admincenter.setThis(user);
				
				admincenters.add(admincenter);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admincenters;
	}

	public AdminCenter update(AdminCenter admincenter) {
		try {
			super.update(admincenter);
			PreparedStatement ps = connection.prepareStatement
					("UPDATE ADMINCENTER SET MATRICULE=?  WHERE id=?");
			ps.setString(1, admincenter.getMatricule());
			ps.setLong(2, admincenter.getAdminCenterId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return admincenter;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM ADMINCENTER WHERE id=?");
			ps.setLong(1, id);
			Long userId = this.find(id).getId();
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				super.delete( userId);
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
	
	public List<AdminCenter> find(Center center) {
		List<AdminCenter> admincenters = new ArrayList<AdminCenter>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM ADMINCENTER where CenterId=?");
			ps.setLong(1, center.getId());
			ResultSet rs = ps.executeQuery();
			AdminCenter admincenter;
			User user;
			while(rs.next()) {
				admincenter = new AdminCenter();
				admincenter.setThis(rs);
				
				user = super.find(admincenter.getId() );
				admincenter.setThis(user);
				
				admincenters.add(admincenter);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admincenters;
	}

	

}
