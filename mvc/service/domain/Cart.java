package com.model2.mvc.service.domain;

import java.sql.Date;

public class Cart {
	private int cartNo; 
	private int prodNo;
	private String userId;
	private int status;
	private Date createAt;
	private Date updateAt;
	public int getCartNo() {
		return cartNo;
	}
	public int getProdNo() {
		return prodNo;
	}
	public String getUserId() {
		return userId;
	}
	public int getStatus() {
		return status;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "Cart [cartNo=" + cartNo + ", prodNo=" + prodNo + ", userId=" + userId + ", status=" + status
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
}
