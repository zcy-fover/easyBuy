package com.group.easyBuy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group.easyBuy.dao.CallBack;
import com.group.easyBuy.dao.DAOHelper;
import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dto.Category;

public class CategoryDAO implements IBaseDAO<Category> {

	public boolean save(Category t) {
		return DAOHelper.exeUpdate("insert into tbcategory(cname,summary) values(?,?)", t.getCname(), t.getSummary());
	}

	public boolean update(Category t) {
		return DAOHelper.exeUpdate("update tbcategory set summary=? where Cname=?", t.getSummary(), t.getCname());
	}

	public boolean del(Category t) {
		return DAOHelper.exeUpdate("delete from tbcategory where Cname=?", t.getCname());
	}

	@SuppressWarnings("rawtypes")
	public Category findSingle(final Category t) {
		String sql = "select cid, summary from tbcategory where cname = ?";
		List list = DAOHelper.exeQuery(sql, new String[] { t.getCname() }, new CallBack() {
			@SuppressWarnings("unchecked")
			@Override
			public List getResult(ResultSet rs) {
				List li = null;
				try {
					if (rs.next()) {
						li = new ArrayList();
						Category category = new Category();
						category.setCid(rs.getInt("Cid"));
						category.setCname(t.getCname());
						category.setSummary(rs.getString("Summary"));
						li.add(category);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return list != null ? (Category) list.get(0) : null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Category> findAll() {

		String sql = "select cid,cname, summary from tbcategory";
		List listCategory = DAOHelper.exeQueryAll(sql, new CallBack() {
			public List getResult(ResultSet rs) {
				List li = null;
				li = new ArrayList();
				try {
					while (rs.next()) {
						Category a = new Category();
						a.setCid(rs.getInt("cid"));
						a.setCname(rs.getString("cname"));
						a.setSummary(rs.getString("summary"));
						li.add(a);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return listCategory != null ? listCategory : null;
	}

	@SuppressWarnings("rawtypes")
	public Category findSingleById(final int cid) {
		String sql = "select * from tbcategory where cid = ?";
		List list = DAOHelper.exeQuery(sql, new Object[] { cid }, new CallBack() {
			@SuppressWarnings({ "unchecked" })
			@Override
			public List getResult(ResultSet rs) {
				List li = null;
				try {
					if (rs.next()) {
						li = new ArrayList();
						Category category = new Category();
						category.setCid(cid);
						category.setCname(rs.getString("cname"));
						category.setSummary(rs.getString("Summary"));
						li.add(category);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return list != null ? (Category) list.get(0) : null;
	}

}
