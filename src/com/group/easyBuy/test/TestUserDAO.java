package com.group.easyBuy.test;

import java.util.List;

import org.junit.Test;

import com.group.easyBuy.dao.impl.UserDAO;
import com.group.easyBuy.dto.User;

public class TestUserDAO {

	private UserDAO userDAO = new UserDAO();
	@Test
	public void testSave() {
		User user = new User();
		user.setUsername("user");
		user.setPassword("123456");
		user.setPhone("15207189057");
		user.setAddress("升升公寓");

		userDAO.save(user);

	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setUsername("chiho");
		user.setPassword("2222222");
		user.setPhone("12345678910");
		user.setAddress("升升公寓");

		userDAO.update(user);
	}

	@Test
	public void testDel() {
		User user = new User();
		user.setUsername("chiho");

		userDAO.del(user);
	}

	
	@Test
	public void testFindSingle() {
		User user = new User();
		user.setUsername("chiho");
		user =userDAO.findSingle(user);
		System.out.println(user.getUserid()+" "+user.getUsername() + "  " + user.getPassword() + " "+user.getPhone()+" "+ user.getAddress());
	}

	@Test
	public void testFindAll() {
		List<User> listUser = userDAO.findAll();
		for(User user: listUser){
			System.out.println(user.getUserid() + "--" + user.getUsername()+ "--" + user.getPassword()+ "--" + user.getPhone()+ "--" + user.getAddress());
		}
	}

}
