package com.group.easyBuy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * @author Administrator
 *JDBC连接数据六个步骤
 *1.加载驱动
 *2.获取连接
 *3.获取执行命令
 *4.执行
 *5.处理结果
 *6.关闭资源
 */
public class DBUtils {
	//数据库连接驱动类路径
	public static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
	//数据库url
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/easyBuy";
	//数据库账号
	public static final String USERNAME = "root";
	//数据库密码
	public static final String PASSWORD = "";
	private static Connection conn;
	
	static{
		try {
			//加载驱动
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("请检查驱动包路径");
		}
	}
	
	//2.获取数据库连接
	public static Connection getConn(){
		try {
			//判断是否存在连接
			if(conn == null || conn.isClosed()){
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
