package com.group.easyBuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.group.easyBuy.utils.DBUtils;

public class DAOHelper {

	/**
	 * 通过该方法实现对于数据表的所有增，删，改操作
	 * 
	 * @return
	 */
	public static boolean exeUpdate(String sql, String... args) {
		Connection conn = DBUtils.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// select c1,c2,c3 from tbXXX where id=?
	/**
	 * 对于所有查询的封装
	 * 
	 * @param sql
	 * @param args
	 * @param call
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List exeQuery(String sql, String[] args, CallBack call) {
		Connection conn = DBUtils.getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					ps.setObject(i + 1, args[i]);
				}
			}
			ResultSet rs = ps.executeQuery();
			return call.getResult(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

//	public static List exeQueryAll(String sql) {
//		Connection conn = DBUtils.getConn();
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			List<Admin> = rs.
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
