package com.group.easyBuy.test;

import org.junit.Test;

import com.group.easyBuy.dto.Admin;
import com.group.easyBuy.service.AdminService;
import com.group.easyBuy.service.ServiceModel;

public class TestAdminService {

	private AdminService adminService = new AdminService();

	@Test
	public void testLogin() {

		Admin admin = new Admin();
		admin.setUsername("ZhangChongyi");
		admin.setPassword("123456");
		ServiceModel model = adminService.login(admin);
		System.out.println(model.getMessage());

	}

}
