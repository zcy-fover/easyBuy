package com.group.easyBuy.dao.impl;

import java.util.List;

import com.group.easyBuy.dao.DAOHelper;
import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dto.Orders;

public class OrdersDAO implements IBaseDAO<Orders> {

	public boolean save(Orders t) {
		return DAOHelper.exeUpdate("insert into tborders(userid,gid,orderno,count,state,total) values(?,?,?,?,?,?)",
				t.getUser().getUserid(), t.getGoods().getGid(), t.getOrderNo(), t.getCount(), t.getState(),
				t.getTotalPrice());
		
	}

	public boolean update(Orders t) {
		return false;
	}

	public boolean del(Orders t) {
		return false;
	}

	public Orders findSingle(Orders t) {
		return null;
	}

	public List<Orders> findAll() {
		return null;
	}

}
