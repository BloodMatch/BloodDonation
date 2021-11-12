package dao.entities;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.http.HttpServletRequest;

import dao.implementation.BagDaoImp;
import dao.implementation.CenterDaoImp;
import dao.implementation.StockDaoImp;
import dao.interfaces.IBagDao;
import dao.interfaces.ICenterDao;
import dao.interfaces.IEntity;
import dao.interfaces.IStockDao;

public class Stock implements Serializable, IEntity<Stock>{
	
	private long id;
	private long quantity;
	private Boolean required;
	private long CenterId;
	private long BagId;

	private Bag bag;
	private Center center;
	
	// Dao
	private static IStockDao stockDao = new StockDaoImp();
	private static IBagDao bagDao = new BagDaoImp();
	private static ICenterDao centerDao = new CenterDaoImp();

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock( long quantity, Boolean required, long CenterId, long BagId) {
		super();
		this.quantity = quantity;
		this.required = required;
		this.CenterId = CenterId;
		this.BagId = BagId;
	}

	public void setThis(Stock bag){
		this.id = bag.getId();
		this.quantity = bag.getQuantity();
		this.required = bag.getRequired();
		this.CenterId = bag.getCenterId();
		this.BagId = bag.getBagId();
	}

	public void setThis(HttpServletRequest request){
		this.id = Long.parseLong(request.getParameter("id"));
		this.quantity = Long.parseLong(request.getParameter("quantity"));
		this.required = Boolean.parseBoolean(request.getParameter("required"));
		this.CenterId = Long.parseLong(request.getParameter("CenterId"));
		this.BagId = Long.parseLong(request.getParameter("BagId"));

	}

	public void setThis(ResultSet rs){
		try{
			this.id = rs.getLong("id");
			this.quantity = rs.getLong("quantity");
			this.required = rs.getBoolean("required");
			this.CenterId = rs.getLong("CenterId");
			this.BagId = rs.getLong("BagId");

		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public long getCenterId() {
		return CenterId;
	}

	public void seCenterId(long CenterId) {
		this.CenterId = CenterId;
	}

	public long getBagId() {
		return BagId;
	}

	public void setBagId(long BagId) {
		this.BagId = BagId;
	}
	
	public Bag getBag() {
		return bag;
	}
	
	public void setBag() {
		this.bag = bagDao.find(this);
	}
	
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	
	public Center getCenter() {
		return center;
	}
	
	public void setCenter() {
		this.center= centerDao.find(this);
	}
	
	public void setCenter(Center center) {
		this.center = center;
	}

	@Override
	public Stock save() {
		try {
			return stockDao.update(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Stock add() {
		try {
			return stockDao.insert(this);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove() {
		try {
			return stockDao.delete(this.id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
