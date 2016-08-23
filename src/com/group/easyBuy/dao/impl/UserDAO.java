package com.group.easyBuy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group.easyBuy.dao.CallBack;
import com.group.easyBuy.dao.DAOHelper;
import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dto.User;

public class UserDAO implements IBaseDAO<User>{

	public boolean save(User t) {
		return DAOHelper.exeUpdate("insert into tbuser(username,password,phone,address) values(?,?,?,?)",
				t.getUsername(),t.getPassword(),t.getPhone(),t.getAddress());
	}

	public boolean update(User t) {
		return DAOHelper.exeUpdate("update tbuser set password=? ,phone =? ,address =? where username=?", 
				t.getPassword(),t.getPhone(),t.getAddress(),t.getUsername());
	}

	public boolean del(User t) {
		return  DAOHelper.exeUpdate("delete from tbuser where username=?", t.getUsername());
	}

	@SuppressWarnings("rawtypes")
	public User findSingle(final User t) {
		String sql = "select userid,username,password,phone,address from tbuser where username = ?";
		List list = DAOHelper.exeQuery(sql, new String[]{t.getUsername()}, new CallBack() {
			@SuppressWarnings("unchecked")
			@Override
			public List getResult(ResultSet rs) {
				List li = null;
				try {
					if(rs.next()){
						li = new ArrayList();
						User user = new User();
						user.setUserid(rs.getInt("userid"));
						user.setUsername(t.getUsername());
						user.setPassword(rs.getString("password"));
						user.setPhone(rs.getString("phone"));
						user.setAddress(rs.getString("address"));
						li.add(user);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return list != null ? (User)list.get(0):null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<User> findAll() {
		String sql = "select userid,username, password, phone, address from tbuser";
		List listUser = DAOHelper.exeQueryAll(sql, new CallBack() {
			public List getResult(ResultSet rs) {
				List li = null;
				li = new ArrayList();
				try {
					while (rs.next()) {
						User a = new User();
						a.setUserid(rs.getInt("userid"));
						a.setUsername(rs.getString("username"));
						a.setPassword(rs.getString("password"));
						a.setPhone(rs.getString("phone"));
						a.setAddress(rs.getString("address"));
						li.add(a);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return listUser != null ? listUser : null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public User findSingleById(final int cid) {
		String sql = "select * from tbuser where userid = ?";
		List<User> list = DAOHelper.exeQuery(sql, new Object[] { cid }, new CallBack() {
			@Override
			public List getResult(ResultSet rs) {
				List li = null;
				try {
					if (rs.next()) {
						li = new ArrayList();
						User user = new User();
						user.setUsername(rs.getString("username"));
						user.setPassword(rs.getString("password"));
						li.add(user);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return list != null ? (User) list.get(0) : null;
	}
	
}
