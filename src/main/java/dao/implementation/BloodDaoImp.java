package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.Blood;
import dao.entities.Donor;
import dao.interfaces.IBloodDao;

public class BloodDaoImp implements IBloodDao{
	private Connection connection = DbConnection.getConnection();

	public Blood insert(Blood blood) {
		return null;
	}

	public Blood find(long id) {
		Blood blood = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM BLOOD WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				blood = new Blood();
				blood.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return blood;
	}

	public List<Blood> findAll() {
		List<Blood> bloods = new ArrayList<Blood>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM BLOOD");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blood blood = new Blood();
				blood.setThis(rs);
				bloods.add(blood);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bloods;
	}

	public Blood update(Blood blood) {
		return null;
	}

	public Boolean delete(long id) {
		return false;
	}

}
