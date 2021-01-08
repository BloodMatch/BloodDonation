package dao.interfaces;

import java.util.List;
import dao.entities.AdminCenter;
import dao.entities.Center;

public interface IAdminCenterDao{

	/*
	 * List of Admins they belongs to a Center
	 * @List<AdminCenter>
	 */
	public List<AdminCenter> find(Center center);
}
