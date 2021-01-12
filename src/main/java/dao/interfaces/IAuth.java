package dao.interfaces;

import dao.entities.User;

public interface IAuth {
	public User login(String email, String password);
	
	public Boolean logout (User user);
}
