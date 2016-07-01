package com.group.easyBuy.service;

import java.util.List;

import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dao.impl.OrdersDAO;
import com.group.easyBuy.dto.Orders;

/**
 * @Title OrdersService.java
 * @Description 订单服务
 *
 * @author zcy-fover
 * @Date 2016年7月1日 下午1:32:48
 * @Version V1.0
 */
public class OrdersService {

	private IBaseDAO<Orders> ordersDAO = new OrdersDAO();
	private ServiceModel model = null;
	
	public ServiceModel addOrders(Orders orders){
		
		boolean isAccess = ordersDAO.save(orders);
		if(isAccess){
			model = new ServiceModel("添加成功", 1, true);
		}else{
			model = new ServiceModel("添加失败", 0, false);
		}
		return model;
	}
	
	public List<Orders> viewOrders(){
		List<Orders> listOrders = ordersDAO.findAll();
		return listOrders;
	}
	
}
