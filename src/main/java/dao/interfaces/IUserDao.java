package dao.interfaces;


import java.util.List;

import dao.entities.Donor;
import dao.entities.User;

public interface IUserDao extends IAuth {
	/*
	 * Register new User into dataBase
	 * @return User
	 */
	public User register(User user);
	
	/*
	 * Search for User in dataBase
	 * @return User
	 */
	public User find(long id);
	
	/*
	 * Search for User in dataBase
	 * @return User
	 */
	public User findByEmail(String email);
	
	/*
	 * Get all Users from dataBase
	 * @return List<User>
	 */
	public List<User> all();
	
	/*
	 * Update User in dataBase
	 * @return User
	 */
	public User update(User user);
	
	/*
	 * Delete User from dataBase
	 * @return Boolean
	 */
	public Boolean delete(long id);
	
	public User find(Donor donor);
	
}
