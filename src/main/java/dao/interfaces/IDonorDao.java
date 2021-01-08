package dao.interfaces;

import java.util.List;

import dao.entities.Donor;

public interface IDonorDao {
	
	/*
	 * Register new Donor into dataBase
	 * @return Donor
	 */
	public Donor create(Donor user);
	
	/*
	 * Search for Donor in dataBase
	 * @return Donor
	 */
	public Donor find(long id);
	
	
	/*
	 * Get all Donor from dataBase
	 * @return List<Donor>
	 */
	public List<Donor> all();
	
	/*
	 * Update Donor in dataBase
	 * @return Donor
	 */
	public Donor update(Donor user);
	
	/*
	 * Delete Donor from dataBase
	 * @return Boolean
	 */
	public Boolean delete(long id);
}
