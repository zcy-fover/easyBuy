package com.group.easyBuy.test;

import java.util.List;

import org.junit.Test;

import com.group.easyBuy.dao.impl.CategoryDAO;
import com.group.easyBuy.dao.impl.GoodsDAO;
import com.group.easyBuy.dto.Category;
import com.group.easyBuy.dto.Goods;

public class TestGoodsDAO {

	private GoodsDAO  goodsDAO = new GoodsDAO();
	private CategoryDAO categoryDAO = new CategoryDAO();
	@Test
	public void testSave() {
		Goods  goods = new Goods();
		Category category = new Category();
		category.setCname("food");
		category =categoryDAO.findSingle(category);
		goods.setGname("康师傅");
		goods.setCategory(category);
		goods.setPrice(12.0);
		goods.setOffset(0.3);
		goods.setStorage(30);
		
		goodsDAO.save(goods);
	}

	@Test
	public void testUpdate() {
		Goods  goods = new Goods();
		goods.setGname("周黑鸭");
		goods.setPrice(44.0);
		goods.setOffset(0.3);
		goods.setStorage(30);
		
		goodsDAO.update(goods);
	}

	@Test
	public void testDel() {
		Goods  goods = new Goods();
		goods.setGname("康师傅");
	
		goodsDAO.del(goods);
	}

	@Test
	public void testFindSingle() {
		Goods goods = new Goods();
		goods.setGname("周黑鸭");
		goods =goodsDAO.findSingle(goods);
		System.out.println(goods.getGid()+" "+goods.getCategory().getCid() + "  " +goods.getGname() + "  " + goods.getPrice() + " "+goods.getOffset()+" "+ goods.getStorage()+" "+goods.getTime());
	}

	@Test
	public void testFindAll() {
		List<Goods> listGoods = goodsDAO.findAll();
		for(Goods goods: listGoods){
			System.out.println(goods.getGid()+" "+goods.getCategory().getCid() + "  " +goods.getGname() + "  " + goods.getPrice() + " "+goods.getOffset()+" "+ goods.getStorage()+" "+goods.getTime());
		}
	}


}
