package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.Appointment;
import dao.entities.Donor;
import dao.entities.User;
import dao.interfaces.IDonorDao;

public class DonorDaoImp extends UserDaoImp implements IDonorDao{
	private Connection connection = DbConnection.getConnection();

	public Donor insert(Donor donor) {
		try {
			
			super.insert(donor);
			
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO DONOR( CIN, BIRTHDAY, GENDER, CITY, IMAGE, BLOODID, USERID) VALUES(?,?,?,?,?,?,?) ");
			ps.setString(1, donor.getCin());
			ps.setString(2, donor.getBirthDay());
			ps.setString(3, donor.getGender());
			ps.setString(4, donor.getCity());
			ps.setString(5, donor.getImage());
			ps.setLong(6, donor.getBloodId());
			ps.setLong(7, donor.getId());
			
			if(ps.execute()) { // 1 : one row affected
				return donor;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Donor find(long id) {
		Donor donor = null;
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM DONOR WHERE UserId = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				donor = new Donor();
				donor.setThis(rs);
				
				user = super.find( id);
				donor.setThis(user);
				
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return donor;
	}

	public Donor find(String cin) {
		Donor donor = null;
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM DONOR WHERE cin = ?");
			ps.setString(1, cin);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				donor = new Donor();
				donor.setThis(rs);
				
				user = super.find( donor.getId());
				donor.setThis(user);
				
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return donor;
	}
	

	public List<User> findAll() {
		List<User> donors = new ArrayList<User>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM DONOR");
			ResultSet rs = ps.executeQuery();
			Donor donor;
			User user;
			while(rs.next()) {
				donor = new Donor();
				donor.setThis(rs);
				
				user = super.find(donor.getId() );
				donor.setThis(user);
				
				donors.add(donor);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return donors;
	}

	public Donor update(Donor donor) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE DONOR SET BIRTHDAY=?, GENDER=?, CITY=? , IMAGE=?, BLOODID=? WHERE cin=?");
			ps.setString(1, donor.getBirthDay());
			ps.setString(2, donor.getGender());
			ps.setString(3, donor.getCity());
			ps.setString(4, donor.getImage());
			ps.setLong(5, donor.getBloodId());
			ps.setString(6, donor.getCin());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return donor;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM DONOR WHERE UserId=?");
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

	public Boolean delete(String cin) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM DONOR WHERE cin=?");
			ps.setString(1, cin);
			//Long userId = this.find(cin).getId();
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				//super.delete( userId);
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Donor find(User user) {
		return this.find(user.getId());
	}
	
	public Donor find(Appointment appointment) {
		return this.find(appointment.getDonorCin());
	}
	
}
