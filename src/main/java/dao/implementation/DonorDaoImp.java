package dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.entities.Donor;
import dao.interfaces.IDonorDao;


public class DonorDaoImp implements IDonorDao{

	private Connection connection = DbConnection.getConnection();
	
	public Donor create(Donor donor) {
		System.out.println("User id : "+donor.getId());
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO DONOR (cin, birthday, sexe, Bloodid, ville, Userid) VALUES(?, ?, ?, ?, ?, ?)");
			ps.setString(1, donor.getCIN());
			ps.setString(2,	donor.getBirthday());
			ps.setString(3, donor.getGender());
			ps.setInt(4, donor.getBloodid());
			ps.setString(5, donor.getCity());
			ps.setLong(6, donor.getId()); // User id Not Donor id
			
			if(ps.executeUpdate() == 1) {
				ps.close();
				return donor;
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Donor find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Donor> all() {
		// TODO Auto-generated method stub
		return null;
	}

	public Donor update(Donor user) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean delete(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
