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
	private Connection connection = DbConnection.getConnection();

	public AdminCenter insert(AdminCenter admincenter) {
		try {
			
			super.register(admincenter);
			
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO ADMINCENTER( MATRICULE, CENTERID, USERID) VALUES(?,?,?) ");
			ps.setString(1, admincenter.getMatricule());
			ps.setLong(6, admincenter.getCenterId());
			ps.setLong(7, admincenter.getId());
			
			if(ps.execute()) { // 1 : one row affected
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
					("SELECT DISTINCT * FROM ADMINCENTER WHERE UserId = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				admincenter = new AdminCenter();
				admincenter.setThis(rs);
				
				user = super.find( id);
				admincenter.setThis(user);
				
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return admincenter;
	}

	public AdminCenter find(String matricule) {
		AdminCenter admincenter = null;
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM ADMINCENTER WHERE matricule = ?");
			ps.setString(1, matricule);
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
			PreparedStatement ps = connection.prepareStatement
					("UPDATE ADMINCENTER SET CENTERID=? WHERE matricule=?");
			ps.setLong(1, admincenter.getCenterId());
			ps.setString(2, admincenter.getMatricule());
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
					("DELETE FROM ADMINCENTER WHERE UserId=?");
			ps.setLong(1, id);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				//super.delete( id);
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean delete(String matricule) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM ADMINCENTER WHERE matricule=?");
			ps.setString(1, matricule);
			//Long userId = this.find(matricule).getId();
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				//super.delete( userId);
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<AdminCenter> find(Center center) {
		List<AdminCenter> admincenters = new ArrayList<AdminCenter>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM ADMINCENTER WHERE CenterId = ?");
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
