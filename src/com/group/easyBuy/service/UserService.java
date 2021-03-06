package com.group.easyBuy.service;

import java.util.List;

import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dao.impl.UserDAO;
import com.group.easyBuy.dto.User;

public class UserService {

	private IBaseDAO<User> userDAO = new UserDAO();
	private ServiceModel model = null;
	
	/**
	 * 完成用户登录功能
	 * @param admin  页面端传递过来的需要查询的管理员
	 * @return
	 */
	public ServiceModel login(User user){
		User userTemp = userDAO.findSingle(user);
		if(userTemp != null){
			if(userTemp.getPassword().equals(user.getPassword())){
				model = new ServiceModel("登录成功", 1, true);
			} else{
				model = new ServiceModel("密码错误", 0, false);
			}
		}else{
			model = new ServiceModel("用户不存在", -1, false);
		}
		return model;
	}
	
	/**
	 * 用于添加用户服务方法
	 * @param user
	 * @return
	 */
	public ServiceModel addUser(User user){
		boolean isAccess = userDAO.save(user);
		if(isAccess){
			model = new ServiceModel("注册成功", 1, true);
			
		}else{
			model = new ServiceModel("注册失败", 0, false);
		}
		return model;
	}
	
	public List<User> viewUser(){
		List<User> listUser = userDAO.findAll();
		return listUser;
	}
	
	public boolean deleteUser(User user){
		return userDAO.del(user);
	}
	
}
