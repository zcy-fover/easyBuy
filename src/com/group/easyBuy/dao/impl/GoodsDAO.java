package com.group.easyBuy.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.group.easyBuy.dao.CallBack;
import com.group.easyBuy.dao.DAOHelper;
import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dto.Category;
import com.group.easyBuy.dto.Goods;

public class GoodsDAO implements IBaseDAO<Goods>{

	public boolean save(Goods t) {
		return DAOHelper.exeUpdate("insert into tbgoods(cid,gname,price,offset,storage,gtime) values(?,?,?,?,?,?)",
				t.getCategory().getCid(),t.getGname(),t.getPrice(),t.getOffset(),t.getStorage(),t.getTime());
	}

	public boolean update(Goods t) {
		return DAOHelper.exeUpdate("update tbgoods set price=?, offset=?, storage=?  where gname=?",
				t.getPrice(),t.getOffset(),t.getStorage(),t.getGname());
	}

	public boolean del(Goods t) {
		return DAOHelper.exeUpdate("delete from tbgoods where gname=?", t.getGname());
	}

	@SuppressWarnings("rawtypes")
	public Goods findSingle(final Goods t) {
		String sql = "select gid,cid,price,offset,storage,gtime from tbgoods where gname = ?";
		List list = DAOHelper.exeQuery(sql, new String[]{t.getGname()}, new CallBack() {		
			CategoryDAO categoryDAO = new CategoryDAO();

			@SuppressWarnings("unchecked")
			@Override
			public List getResult(ResultSet rs) {
				List li = null;
				try {
					if(rs.next()){
						li = new ArrayList();
						Goods goods = new Goods();
						goods.setGid(rs.getInt("Gid"));
						goods.setGname(t.getGname());
						int cid = rs.getInt("Cid");
						Category category = new Category();
						category = categoryDAO.findSingleById(cid);
						goods.setCategory(category);
						goods.setPrice(rs.getDouble("price"));
						goods.setOffset(rs.getDouble("offset"));
						goods.setStorage(rs.getInt("storage"));
						goods.setTime(rs.getTimestamp("gtime"));
						li.add(goods);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return list != null ? (Goods)list.get(0):null;
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Goods> findAll() {
		String sql = "select gid,cid,gname,price,offset,storage,gtime from tbgoods";
		List listGoods = DAOHelper.exeQueryAll(sql, new CallBack() {
			CategoryDAO categoryDAO = new CategoryDAO();

			@Override
			public List getResult(ResultSet rs) {
				List li = null;
				li = new ArrayList();
				try {
					while(rs.next()){
						Goods a = new Goods();
						a.setGid(rs.getInt("Gid"));
						a.setGname(rs.getString("gname"));
						int cid = rs.getInt("Cid");
						Category category = new Category();
						category = categoryDAO.findSingleById(cid);
						a.setCategory(category);
						a.setPrice(rs.getDouble("price"));
						a.setOffset(rs.getDouble("offset"));
						a.setStorage(rs.getInt("storage"));
						a.setTime(rs.getTimestamp("gtime"));
						li.add(a);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return listGoods != null ? listGoods : null;
	}

}
