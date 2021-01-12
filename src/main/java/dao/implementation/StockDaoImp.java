package dao.implementation;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import dao.DbConnection;
import dao.entities.Stock;
import dao.interfaces.IStockDao;

public class StockDaoImp implements IStockDao{
	private final static Connection connection = DbConnection.getConnection();

	public Stock insert(Stock stock) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("INSERT INTO STOCK( QUANTITY, REQUIRED, CENTERID, BAGID) VALUES(?,?,?,?) ", Statement.RETURN_GENERATED_KEYS);
			ps.setLong(1, stock.getQuantity());
			ps.setBoolean(2, stock.getRequired());
			ps.setLong(3, stock.getCenterId());
			ps.setLong(4, stock.getBagId());
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();
			if(rs.next()) { // 1 : one row affected
				stock.setId(rs.getInt(1));
				return stock;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Stock find(long id) {
		Stock stock = null;
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT DISTINCT * FROM STOCK WHERE id = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				stock = new Stock();
				stock.setThis(rs);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}

	public List<Stock> findAll() {
		List<Stock> stocks = new ArrayList<Stock>();
		try {
			PreparedStatement ps = connection.prepareStatement
					("SELECT * FROM STOCK");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Stock stock = new Stock();
				stock.setThis(rs);
				stocks.add(stock);
			}
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return stocks;
	}

	public Stock update(Stock stock) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("UPDATE STOCK SET QUANTITY=?, REQUIRED=? WHERE id=?");
			ps.setLong(1, stock.getQuantity());
			ps.setBoolean(2, stock.getRequired());
			ps.setLong(3, stock.getId());
			if(ps.executeUpdate() == 1) { // 1 : one row affected
				return stock;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean delete(long id) {
		try {
			PreparedStatement ps = connection.prepareStatement
					("DELETE FROM STOCK WHERE id=?");
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
