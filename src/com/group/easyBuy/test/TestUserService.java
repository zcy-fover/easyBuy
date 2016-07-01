package com.group.easyBuy.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.group.easyBuy.dto.User;
import com.group.easyBuy.service.UserService;

public class TestUserService {

	private UserService userService = new UserService();
	
	@Test
	public void testLogin() {
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("zhangchongyi");
		user.setPassword("123");
		user.setPhone("15207189058");
		user.setAddress("武汉理工大学");
		userService.addUser(user);
	}

	@Test
	public void testViewUser(){
		List<User> listUser = new ArrayList<>();
		listUser = userService.viewUser();
		for(User user: listUser){
			System.out.println(user.getUsername());
		}
	}
	
}
