package dao.interfaces;

import java.util.List;

//import java.util.List;

import dao.entities.Appointment;
import dao.entities.Center;
import dao.entities.Donor;
import dao.entities.User;

public interface IDonorDao extends IDao<Donor>{
	
	
	/*
	 * Relationships
	 */
	
	
	/*
	 * Delete a Donor from dataBase
	 * @return Donor
	 */

	public Donor find(User user);
	
	/*
	 * apointment belogs to donor 
	 * @return Donor
	 */
	public Donor find(Appointment appointment);
	
	
	public Donor tested(Donor donor, Boolean value);
}

/*
 * Find the Objcet(Owner/Responsable/that belong to) of hadchi li ghat3tini 
 * T1 find(T2) :: find the T1 of T2
 * */
