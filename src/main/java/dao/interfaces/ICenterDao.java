package dao.interfaces;

import java.util.List;

import dao.entities.AdminCenter;
import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;
import dao.entities.Stock;

public interface ICenterDao extends IDao<Center> {
    /*
     * RelationShipes
     * */
	public List<Center> find(Donor donor);
	public Center find(AdminCenter admincenter);
    public Center find(Appointment appointment);
    public Center find(Stock stock);
    
    /*
     * Business
     * */
    public List<String> getOtherCities(String city);
}
