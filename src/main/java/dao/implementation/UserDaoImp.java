package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import business.Hash;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.User;
import dao.interfaces.IUserDao;

public class UserDaoImp implements IUserDao{
	private Connection connection = DbConnection.getConnection();

	public User register(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO USER (firstName, lastName, email, passwd, phone, active, role) VALUES(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, user.getFirstName());
			ps.setString(2,	user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhone());
			ps.setBoolean(6, user.getActive());
			ps.setString(7, user.getRole());
			
			if(ps.executeUpdate() == 1) {
				ps.close();
				user.setId(this.lastUserId());
				return user;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public User find(long id) {
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM USER WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(id);
				user.setFirstName(rs.getString("firstName")); 
				user.setLastName(rs.getString("lastName")); 
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("passwd"));
				user.setPhone(rs.getString("phone"));
				user.setActive(rs.getBoolean("active"));
				user.setRole(rs.getString("role"));
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User findByEmail(String email) {
		User user = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM USER WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getLong("id"));
				user.setFirstName(rs.getString("firstName")); 
				user.setLastName(rs.getString("lastName")); 
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("passwd"));
				user.setPhone(rs.getString("phone"));
				user.setActive(rs.getBoolean("active"));
				user.setRole(rs.getString("role"));
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> all() {
		List<User> users = new ArrayList<User>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM USER");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setFirstName(rs.getString("firstName")); 
				user.setLastName(rs.getString("lastName")); 
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("passwd"));
				user.setPhone(rs.getString("phone"));
				user.setActive(rs.getBoolean("active"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public User update(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE USER SET FIRSTNAME=?, LASTNAME=?, EMAIL=?, PASSWD=? ,PHONE=?, ACTIVE=?, ROLE=? WHERE id=?");
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhone());
			ps.setBoolean(6, user.getActive());
			ps.setString(7, user.getRole());
			ps.setLong(8, user.getId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				ps.close();
				return user;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM USER WHERE id=?");
			ps.setLong(1, id);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				ps.close();
				return true;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User login(String email, String password) {
		User user = this.findByEmail(email);
		if(user != null) {
			if(user.getPassword().equals(Hash.makeHash(password))) {
				return user;
			};
		}
		return null;
	}

	public Boolean logout(User user) {
		
		return null;
	}

	public Long lastUserId() {
		Long lastId = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT MAX(id) AS id FROM USER");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				lastId = rs.getLong("id");
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lastId;
	}
}
