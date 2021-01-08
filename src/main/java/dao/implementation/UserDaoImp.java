package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.User;
import dao.interfaces.IUserDao;

public class UserDaoImp implements IUserDao{
	private final static Connection connection = DbConnection.getConnection();

	public User insert(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO USER( FIRSTNAME, LASTNAME, EMAIL, PASSWD, PHONE, ACTIVE, ROLE) VALUES(?,?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPasswd());
			ps.setString(5, user.getPhone());
			ps.setBoolean(6, user.getActive());
			ps.setString(7, user.getRole());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				user.setId(rs.getInt(1));
				return user;
			}

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
				user.setThis(rs);
			}
			ps.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();

		System.out.println("getConnection()");
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM USER");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setThis(rs);
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
			ps.setString(4, user.getPasswd());
			ps.setString(5, user.getPhone());
			ps.setBoolean(6, user.getActive());
			ps.setString(7, user.getRole());
			ps.setLong(8, user.getId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return user;
			}

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
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


}
