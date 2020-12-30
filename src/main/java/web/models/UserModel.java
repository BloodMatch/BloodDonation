package web.models;

import java.util.ArrayList;
import java.util.List;

import dao.entities.User;

public class UserModel {

	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserModel [users=" + users + "]";
	}
	
		
}
