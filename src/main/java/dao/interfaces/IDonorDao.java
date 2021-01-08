package dao.interfaces;

import java.util.List;

import dao.entities.Appointment;
import dao.entities.Donor;
import dao.entities.User;

public interface IDonorDao{
	
	/*
	 * Insert new Donor into dataBase
	 * @return Donor
	 */
	public Donor insert(Donor donor);

	
	/*
	 * Update a Donor in dataBase
	 * @return Donor
	 */
	public Donor update(Donor donor);
	
	/*
	 * Delete a Donor from dataBase
	 * @return Donor
	 */

	//public Donor find(User user);
	
	/*
	 * apointment belogs to donor 
	 * @return Donor
	 */
	//public Donor find(Appointment appointment);
	
}

/*
 * Find the Objcet(Owner/Responsable/that belong to) of hadchi li ghat3tini 
 * T1 find(T2) :: find the T1 of T2
 * */
