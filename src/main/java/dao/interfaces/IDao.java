package dao.interfaces;


import java.util.List;

public interface IDao <T> {
	/*
	 * Insert new Record into dataBase
	 * @return User
	 */
	public T insert(T t);
	
	/*
	 * Find a Record by id dataBase
	 * @return User
	 */
	public T find(long id);
	
	/*
	 * Get all Records from dataBase
	 * @return List<User>
	 */
	public List<T> findAll();
	
	/*
	 * Update a Record in dataBase
	 * @return User
	 */
	public T update(T user);
	
	/*
	 * Delete a Record from dataBase
	 * @return Boolean
	 */
	public Boolean delete(long id);
	
}
