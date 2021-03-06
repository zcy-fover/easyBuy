package com.group.easyBuy.service;

import com.group.easyBuy.dao.IBaseDAO;
import com.group.easyBuy.dao.impl.AdminDAO;
import com.group.easyBuy.dto.Admin;

public class AdminService {

	private IBaseDAO<Admin> baseDAO = new AdminDAO();
	
	/**
	 * 完成登录功能
	 * @param admin  页面端传递过来的需要查询的管理员
	 * @return
	 */
	public ServiceModel login(Admin admin){
		ServiceModel model = null;
		Admin a = (Admin) baseDAO.findSingle(admin);
		if(a != null){
			if(a.getPassword().equals(admin.getPassword())){
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
