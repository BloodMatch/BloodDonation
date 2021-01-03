package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.Bag;
import dao.interfaces.IBagDao;

public class BagDaoImp implements IBagDao{
	private Connection connection = DbConnection.getConnection();

	public Bag insert(Bag bag) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO BAG( QUANTITY, REQUIRED, CENTERID, BLOODID) VALUES(?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, bag.getQuantity());
			ps.setBoolean(2, bag.getRequired());
			ps.setLong(3, bag.getCenterId());
			ps.setLong(4, bag.getBloodId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				bag.setId(rs.getInt(1));
				return bag;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Bag find(long id) {
		Bag bag = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM BAG WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				bag = new Bag();
				bag.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bag;
	}

	public List<Bag> findAll() {
		List<Bag> bags = new ArrayList<Bag>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM BAG");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bag bag = new Bag();
				bag.setThis(rs);
				bags.add(bag);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bags;
	}

	public Bag update(Bag bag) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPREQUIRED BAG SET QUANTITY=?, REQUIRED=? WHERE id=?");
			ps.setLong(1, bag.getQuantity());
			ps.setBoolean(2, bag.getRequired());
			ps.setLong(3, bag.getId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return bag;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM BAG WHERE id=?");
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
