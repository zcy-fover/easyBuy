package com.group.easyBuy.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group.easyBuy.dao.CallBack;
import com.group.easyBuy.dao.DAOHelper;
import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dto.Admin;

public class AdminDAO implements IBaseDAO<Admin> {

	public boolean save(Admin t) {
		return DAOHelper.exeUpdate("insert into tbadmin(username,password) values(?,?)", t.getUsername(),
				t.getPassword());
	}

	public boolean update(Admin t) {
		return DAOHelper.exeUpdate("update tbadmin set password=? where adminid=?", t.getPassword(),
				t.getAdminId() + "");
	}

	public boolean del(Admin t) {
		return DAOHelper.exeUpdate("delete from tbadmin where adminid=?", t.getAdminId().toString());
	}

	@SuppressWarnings("rawtypes")
	public Admin findSingle(final Admin t) {
		String sql = "select adminid,password from tbadmin where username=?";
		List list = DAOHelper.exeQuery(sql, new String[] { t.getUsername() }, new CallBack() {
			@SuppressWarnings("unchecked")
			public List getResult(ResultSet rs) {
				List li = null;
				try {
					if (rs.next()) {
						li = new ArrayList();
						Admin a = new Admin();
						a.setPassword(rs.getString("password"));
						a.setAdminId(rs.getInt("adminid"));
						a.setUsername(t.getUsername());
						li.add(a);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return li;
			}
		});
		return list != null ? (Admin) list.get(0) : null;
	}

	public List<Admin> findAll() {

//		String sql = "select username, password from tbadmin";
		return null;
	}

}
