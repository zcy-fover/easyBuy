package com.group.easyBuy.test;

import java.util.List;

import org.junit.Test;

import com.group.easyBuy.dao.impl.AdminDAO;
import com.group.easyBuy.dto.Admin;

public class TestAdminDAO {

	private AdminDAO adminDAO = new AdminDAO();

	@Test
	public void testSave() {

		Admin admin = new Admin();
		admin.setUsername("ZhangChongyi");
		admin.setPassword("123456");

		adminDAO.save(admin);

	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDel() {
	}

	@Test
	public void testFindSingle() {
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin = adminDAO.findSingle(admin);
		System.out.println(admin.getUsername() + "  " + admin.getPassword());
	}

	@Test
	public void testFindAll() {
		List<Admin> listAdmin = adminDAO.findAll();
		for(Admin admin: listAdmin){
			System.out.println(admin.getAdminId() + "--" + admin.getUsername() + "--" + admin.getPassword());
		}
	}

}
