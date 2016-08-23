package com.group.easyBuy.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.group.easyBuy.dto.Category;
import com.group.easyBuy.service.CategoryService;

public class TestCategoryService {

	private CategoryService service = new CategoryService();
	
	@Test
	public void testGetCategory() {
		List<Category> listCategory = service.getCategory();
		for(Category category: listCategory){
    		System.out.println("商品种类：" + category.getCname());
    	}
	}

	@Test
	public void testAddCategory() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCategory() {
		fail("Not yet implemented");
	}

}
