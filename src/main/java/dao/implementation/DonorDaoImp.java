package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.Donor;
import dao.entities.User;
import dao.interfaces.IDonorDao;

public class DonorDaoImp extends UserDaoImp implements IDonorDao{
	private Connection connection = DbConnection.getConnection();

	public Donor insert(Donor donor) {
		try {
			
			super.insert(donor);
			
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO DONOR( CIN, BIRTHDAY, SEXE, BLOODTYPE, VILLE, IMAGE, USERID) VALUES(?,?,?,?,?,?,?) ");
			ps.setString(1, donor.getCin());
			ps.setString(2, donor.getBirthDay());
			ps.setString(3, donor.getSexe());
			ps.setString(4, donor.getBloodType());
			ps.setString(5, donor.getVille());
			ps.setString(6, donor.getImage());
			ps.setLong(7, donor.getId());
			
			if(ps.execute()) { // 1 : one row affected
				return donor;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
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
				donor.setCin(cin);
				donor.setBirthDay(rs.getString("birthDay")); 
				donor.setSexe(rs.getString("sexe")); 
				donor.setBloodType(rs.getString("bloodType"));
				donor.setVille(rs.getString("ville"));
				donor.setImage(rs.getString("image"));
				donor.setId(rs.getLong("userId"));
				
				user = super.find(donor.getId() );
				
				donor.setFirstName( user.getFirstName());
				donor.setLastName( user.getLastName());
				donor.setEmail( user.getEmail());
				donor.setPassword( user.getPassword());
				donor.setPhone( user.getPhone());
				donor.setActive( user.getActive());
				donor.setRole( user.getRole());
				
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
				donor.setCin(rs.getString("cin"));
				donor.setBirthDay(rs.getString("birthDay")); 
				donor.setSexe(rs.getString("sexe")); 
				donor.setBloodType(rs.getString("bloodType"));
				donor.setVille(rs.getString("ville"));
				donor.setImage(rs.getString("image"));
				donor.setId(rs.getLong("userId"));
				user = super.find(donor.getId() );
				
				donor.setFirstName( user.getFirstName());
				donor.setLastName( user.getLastName());
				donor.setEmail( user.getEmail());
				donor.setPassword( user.getPassword());
				donor.setPhone( user.getPhone());
				donor.setActive( user.getActive());
				donor.setRole( user.getRole());
				
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
					("UPDATE DONOR SET BIRTHDAY=?, SEXE=?, BLOODTYPE=?, VILLE=? , IMAGE=? WHERE cin=?");
			ps.setString(1, donor.getBirthDay());
			ps.setString(2, donor.getSexe());
			ps.setString(3, donor.getBloodType());
			ps.setString(4, donor.getVille());
			ps.setString(5, donor.getImage());
			ps.setString(6, donor.getCin());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return donor;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
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

}
