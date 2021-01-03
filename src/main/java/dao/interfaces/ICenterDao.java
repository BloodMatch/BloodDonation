package dao.interfaces;

import java.util.List;

import dao.entities.AdminCenter;
import dao.entities.Appointment;
import dao.entities.Bag;
import dao.entities.Center;

public interface ICenterDao extends IDao<Center> {
    
    public Center find(AdminCenter admincenter);
    public Center find(Appointment appointment);
    //public Center find(Bag bag);
}
