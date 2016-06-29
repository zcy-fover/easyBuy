package com.group.easyBuy.dao;

import java.util.List;

public interface IBaseDAO<T> {

	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public boolean save(T t);
	
	/**
	 * 修改
	 * @param t
	 * @return
	 */
	public boolean update(T t);
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	public boolean del(T t);
	
	/**
	 * 查询单个对象
	 * @param t
	 * @return
	 */
	public T findSingle(T t);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<T> findAll();
}
