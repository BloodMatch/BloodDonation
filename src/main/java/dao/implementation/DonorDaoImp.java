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
	private final static Connection connection = DbConnection.getConnection();

	public Donor insert(Donor donor) {
		try {
			
			super.insert(donor);
			
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO DONOR( CIN, BIRTHDATE, GENDER, CITY, IMAGE, ZIPCODE, USERID) VALUES(?,?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, donor.getCin());
			ps.setString(2, donor.getBirthDate());
			ps.setString(3, donor.getGender());
			ps.setString(4, donor.getCity());
			ps.setString(5, donor.getImage());
			ps.setLong(6, donor.getZIPCode());
			ps.setLong(7, donor.getId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				donor.setDonorId(rs.getInt(1));
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
					("SELECT DISTINCT * FROM DONOR WHERE id = ?");
			ps.setLong(1, id);
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
				
				user = super.find( donor.getId());
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
			super.update(donor);
			PreparedStatement ps = connection.prepareStatement
					("UPDATE DONOR SET CIN=?, BIRTHDATE=?, GENDER=?, `GROUP`=?, CITY=?, ZIPCODE=? , IMAGE=? WHERE id=?");
			ps.setString(1, donor.getCin());
			ps.setString(2, donor.getBirthDate());
			ps.setString(3, donor.getGender());
			ps.setString(4, donor.getGroup());
			ps.setString(5, donor.getCity());
			ps.setLong(6, donor.getZIPCode());
			ps.setString(7, donor.getImage());
			ps.setLong(8, donor.getDonorId());
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
					("DELETE FROM DONOR WHERE id=?");
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
	public Donor find(User user) {
		Donor donor = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM DONOR WHERE UserId = ?");
			ps.setLong(1, user.getId());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				donor = new Donor();
				donor.setThis(rs);				
				donor.setThis(user);
				
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return donor;
	}

	public Donor find(Appointment appointment) {
		
		return find(appointment.getDonorId());
	}

}
