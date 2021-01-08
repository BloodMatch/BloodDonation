package dao.interfaces;

import java.util.List;

import dao.entities.Blood;

public interface IBloodDao {
	/*
	 * Register new Blood into dataBase
	 * @return Blood
	 */
	public Blood create(Blood blood);
	
	/*
	 * Search for Blood in dataBase
	 * @return Blood
	 */
	public Blood find(long id);
	
	/*
	 * Get all Blood from dataBase
	 * @return List<Blood>
	 */
	public List<Blood> all();
	
	/*
	 * Update Blood in dataBase
	 * @return Blood
	 */
	public Blood update(Blood blood);
	
	/*
	 * Delete Blood from dataBase
	 * @return Boolean
	 */
	public Boolean delete(long id);
}
