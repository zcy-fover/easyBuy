package com.group.easyBuy.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Title CallBack.java
 * @Description 回调函数
 *
 * @author zcy-fover
 * @param <T>
 * @Date 2016年6月28日 下午1:27:07
 * @Version V1.0
 */
public interface CallBack {
	@SuppressWarnings("rawtypes")
	public List getResult(ResultSet rs);
}
