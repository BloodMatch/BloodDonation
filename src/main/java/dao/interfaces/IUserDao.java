package dao.interfaces;


import java.util.List;
import dao.entities.User;

public interface IUserDao {
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
	
}
