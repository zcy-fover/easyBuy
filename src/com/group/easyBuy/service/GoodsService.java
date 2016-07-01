package com.group.easyBuy.service;

import java.util.List;

import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dao.impl.GoodsDAO;
import com.group.easyBuy.dto.Goods;

/**
 * @Title GoodsService.java
 * @Description 商品的service方法
 *
 * @author zcy-fover
 * @Date 2016年7月1日 上午12:45:15
 * @Version V1.0
 */
public class GoodsService {

	private IBaseDAO<Goods> goodsDAO = new GoodsDAO();
	private ServiceModel model = null;
	
	/**
	 * 添加商品
	 * @param goods
	 * @return
	 */
	public ServiceModel addGoods(Goods goods){
		boolean isAccess = goodsDAO.save(goods);
		if(isAccess){
			model = new ServiceModel("添加成功", 1, true);
			
		}else{
			model = new ServiceModel("添加失败", 0, false);
		}
		return model;
	}
	
	/**
	 * 显示所有商品
	 * @return
	 */
	public List<Goods> viewGoods(){
		List<Goods> listGoods = goodsDAO.findAll();
		return listGoods;
	}
	
	/**
	 * 删除商品
	 * @param goods
	 * @return
	 */
	public boolean deleteGoods(Goods goods){
		return goodsDAO.del(goods);
	}
	
}
