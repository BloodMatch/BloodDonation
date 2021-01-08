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
import dao.entities.Appointment;
import dao.entities.Center;
import dao.interfaces.ICenterDao;

public class CenterDaoImp implements ICenterDao{
	private Connection connection = DbConnection.getConnection();

	public Center insert(Center center) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO CENTER( CODE, NAME, EMAIL, PHONE1, PHONE2, ADDRESS, CITY, ZIPCODE) VALUES(?,?,?,?,?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, center.getCode());
			ps.setString(2, center.getName());
			ps.setString(3, center.getEmail());
			ps.setString(4, center.getPhone1());
			ps.setString(5, center.getPhone2());
			ps.setString(6, center.getAddress());
			ps.setString(7, center.getCity());
			ps.setLong(8, center.getZIPCode());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				center.setId(rs.getInt(1));
				return center;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Center find(long id) {
		Center center = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM CENTER WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				center = new Center();
				center.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return center;
	}

	public List<Center> findAll() {
		List<Center> centers = new ArrayList<Center>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM CENTER");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Center center = new Center();
				center.setThis(rs);
				centers.add(center);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return centers;
	}

	public Center update(Center center) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE CENTER SET CODE=?, NAME=?, EMAIL=?, PHONE1=? ,PHONE2=?, ADDRESS=?, CITY=?, ZIPCODE=? WHERE id=?");
			ps.setString(1, center.getCode());
			ps.setString(2, center.getName());
			ps.setString(3, center.getEmail());
			ps.setString(4, center.getPhone1());
			ps.setString(5, center.getPhone2());
			ps.setString(6, center.getAddress());
			ps.setString(7, center.getCity());
			ps.setLong(8, center.getZIPCode());
			ps.setLong(9, center.getId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return center;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM CENTER WHERE id=?");
			ps.setLong(1, id);
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return true;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public Center find(AdminCenter admincenter) {
		return this.find(admincenter.getCenterId());
	}

	public Center find(Appointment appointment) {
		return this.find(appointment.getCenterId());
	}

}
