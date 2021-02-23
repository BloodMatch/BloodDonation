package dao.interfaces;

import java.util.List;
import dao.entities.AdminCenter;
import dao.entities.Center;
import dao.entities.Donor;
import dao.entities.User;

public interface IAdminCenterDao{

	/*
	 * List of Admins they belongs to a Center
	 * @List<AdminCenter>
	 */
	public AdminCenter find(User user);
	public List<AdminCenter> find(Center center);
}
