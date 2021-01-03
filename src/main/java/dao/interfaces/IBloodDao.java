package dao.interfaces;

import java.util.List;
import dao.entities.Blood;
import dao.entities.Donor;

public interface IBloodDao extends IDao<Blood> {
	public Blood find(Donor donor);
}
