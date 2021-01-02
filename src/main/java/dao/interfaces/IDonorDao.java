package dao.interfaces;


import dao.entities.Donor;

public interface IDonorDao{
	/*
	 * Register new Donor into dataBase
	 * @return Donor
	 */
	public Donor insert(Donor donor);
	
	/*s
	 * Search for Donor in dataBase
	 * @return Donor
	 */
	public Donor find(String cin);
	
	/*
	 * Get all Donors from dataBase
	 * @return List<Donor>
	 */
//	public List<Donor> findAll();
	
	/*
	 * Update Donor in dataBase
	 * @return Donor
	 */
	public Donor update(Donor donor);
	
	/*
	 * Delete Donor from dataBase
	 * @return Boolean
	 */
	public Boolean delete(String id);
	
}
