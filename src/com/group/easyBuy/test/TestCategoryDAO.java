package com.group.easyBuy.test;

import java.util.List;

import org.junit.Test;

import com.group.easyBuy.dao.impl.CategoryDAO;
import com.group.easyBuy.dto.Category;

public class TestCategoryDAO {

	private CategoryDAO categoryDAO = new CategoryDAO();
	@Test
	public void testSave() {

			Category category = new Category();
			category.setCname("food");
			category.setSummary("13");

			categoryDAO.save(category);

	}

	@Test
	public void testUpdate() {
		Category category = new Category();
		category.setCname("food");
		category.setSummary("13");

		categoryDAO.update(category);

	}

	@Test
	public void testDel() {
		Category category = new Category();
		category.setCname("food");

		categoryDAO.del(category);

	}

	@Test
	public void testFindSingle() {
		Category category = new Category();
		category.setCname("food");
		category =categoryDAO.findSingle(category);
		System.out.println(category.getCname() + "  " + category.getSummary());
	}

	@Test
	public void testFindAll() {
		List<Category> listCategory = categoryDAO.findAll();
		for(Category category: listCategory){
			System.out.println(category.getCid() + "--" + category.getCname()+ "--" + category.getSummary());
		}
	}

}