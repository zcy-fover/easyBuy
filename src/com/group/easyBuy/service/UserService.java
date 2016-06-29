package com.group.easyBuy.service;

import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dao.impl.UserDAO;
import com.group.easyBuy.dto.User;

public class UserService {

private IBaseDAO<User> userDAO = new UserDAO();
	
	/**
	 * 完成用户登录功能
	 * @param admin  页面端传递过来的需要查询的管理员
	 * @return
	 */
	public ServiceModel login(User user){
		ServiceModel model = null;
		User userTemp = userDAO.findSingle(user);
		if(userTemp != null){
			if(userTemp.getPassword().equals(userTemp.getPassword())){
				model = new ServiceModel("登录成功", 1, true);
			} else{
				model = new ServiceModel("密码错误", 0, false);
			}
		}else{
			model = new ServiceModel("用户不存在", -1, false);
		}
		return model;
	}
	
}
