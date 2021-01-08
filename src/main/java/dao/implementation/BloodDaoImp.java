package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.entities.Blood;
import dao.interfaces.IBloodDao;

public class BloodDaoImp implements IBloodDao{
	Connection connection = DbConnection.getConnection();

	public Blood create(Blood blood) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INOT BLOOD (type, description) values(?, ?)");
			ps.setString(1, blood.getType());
			ps.setString(2,	blood.getDescription());
			
			if(ps.executeUpdate() == 1) {
				return blood;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Blood find(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM BLOOD WHERE id=?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Blood blood = new Blood();
				blood.setId(id);
				blood.setType(rs.getString("type"));
				blood.setDescription(rs.getString("description"));
				return blood;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Blood> all() {
		List<Blood> bloods = new ArrayList<Blood>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM BLOOD");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Blood blood = new Blood();
				blood.setId(rs.getLong("id"));
				blood.setDescription(rs.getString("description"));
				blood.setType(rs.getString("type"));
				bloods.add(blood);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bloods;
	}

	public Blood update(Blood blood) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
