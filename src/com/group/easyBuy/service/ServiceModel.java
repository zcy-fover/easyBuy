package com.group.easyBuy.service;

public class ServiceModel {

	private String message;
	private int code;// 表示状态码
	private Object data;// 需要传递对象信息
	private boolean isAccess;// 执行是否成功

	public ServiceModel(String message, boolean isAccess) {
		super();
		this.message = message;
		this.isAccess = isAccess;
	}

	public ServiceModel(String message, int code, boolean isAccess) {
		super();
		this.message = message;
		this.code = code;
		this.isAccess = isAccess;
	}

	public ServiceModel(String message, int code, Object data, boolean isAccess) {
		super();
		this.message = message;
		this.code = code;
		this.data = data;
		this.isAccess = isAccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isAccess() {
		return isAccess;
	}

	public void setAccess(boolean isAccess) {
		this.isAccess = isAccess;
	}

}
