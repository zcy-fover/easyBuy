package com.group.easyBuy.dto;

import java.io.Serializable;

/**
 * 商品配图
 * @author Administrator
 */
public class Imgs implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer imgId;
	private String imgPath;
	private Goods goods;
	public Integer getImgId() {
		return imgId;
	}
	public void setImgId(Integer imgId) {
		this.imgId = imgId;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
