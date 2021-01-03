package dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dao.implementation.UserDaoImp;
import dao.interfaces.IDao;
import dao.entities.User;

public class TestUserDaoImp {
	
	private IDao<User> userDaoImp;

	@Before
	public void setUp() throws Exception {
		this.userDaoImp = new UserDaoImp();
	}

	@Test
	public void testFind() {
		long id1 = 1, id2 = 2;
		// user one dosn't exists
		User user1 = this.userDaoImp.find(id1);
		// user two exists
		User user2 = this.userDaoImp.find(id2);
		assertEquals(null, user1);
		assertEquals(user2.getId(), id2);
	}

}
