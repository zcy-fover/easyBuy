package com.group.easyBuy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group.easyBuy.dao.CallBack;
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
		
		return DAOHelper.exeUpdate("delete from tborders where orderno = ?", t.getOrderNo());
		
	}

	public Orders findSingle(Orders t) {
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Orders> findAll() {

		String sql = "select * from tborders";
		List<Orders> listOrders = DAOHelper.exeQueryAll(sql, new CallBack() {
			public List getResult(ResultSet rs) {
				List li = null;
				li = new ArrayList();
				try {
					while (rs.next()) {
						Orders orders = new Orders();
						orders.setId(rs.getInt("oid"));
						orders.setOrderNo(rs.getString("orderno"));
						orders.setState(rs.getInt("state"));
						orders.setTime(rs.getTimestamp("ordertime"));
						orders.setCount(rs.getInt("count"));
						orders.setTotalPrice(rs.getDouble("total"));
						
						UserDAO userDAO = new UserDAO();
						orders.setUser(userDAO.findSingleById(rs.getInt("userid")));
						
						GoodsDAO goodsDAO = new GoodsDAO();
						orders.setGoods(goodsDAO.findSingleById(rs.getInt("gid")));
						
						li.add(orders);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return listOrders != null ? listOrders : null;
	}

}
