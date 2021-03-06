package com.group.easyBuy.service;

import java.util.List;

import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dao.impl.CategoryDAO;
import com.group.easyBuy.dto.Category;

/**
 * @Title CategoryService.java
 * @Description 商品类型服务方法
 *
 * @author zcy-fover
 * @Date 2016年7月1日 上午12:59:34
 * @Version V1.0
 */
public class CategoryService {

	private IBaseDAO<Category> categoryDAO = new CategoryDAO();
	
	public List<Category> getCategory(){
		List<Category> listCategory = categoryDAO.findAll();
		for(Category category: listCategory){
    		System.out.println("商品种类：" + category.getCname());
    	}
		return listCategory;
	}
	
	public boolean addCategory(Category category){
		return categoryDAO.save(category);
	}
	
	public boolean deleteCategory(Category category){
		return categoryDAO.del(category);
	}
	
}
