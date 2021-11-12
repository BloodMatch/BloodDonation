package dao.interfaces;

//import java.util.List;
import dao.entities.Bag;
//import dao.entities.Donor;
import dao.entities.Stock;

public interface IBagDao extends IDao<Bag> {
	/*
	 * RealationShips
	 * */
	public Bag find(Stock stock);
}
