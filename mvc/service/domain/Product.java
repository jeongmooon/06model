package com.model2.mvc.service.domain;

import java.sql.Date;


public class Product {
	
	private int prodNo; //pk키
	private User user;	//외부키
	private String prodName;
	private String prodContent;
	private String prodCategory;
	private int price;
	private int status;
	private int hideStatus;
	private Date createAt;
	private Date updateAt;
	public int getProdNo() {
		return prodNo;
	}
	public User getUser() {
		return user;
	}
	public String getProdName() {
		return prodName;
	}
	public String getProdContent() {
		return prodContent;
	}
	public int getPrice() {
		return price;
	}
	public int getStatus() {
		return status;
	}
	public int getHideStatus() {
		return hideStatus;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setHideStatus(int hideStatus) {
		this.hideStatus = hideStatus;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", user=" + user + ", prodName=" + prodName + ", prodContent="
				+ prodContent + ", price=" + price + ", status=" + status + ", hideStatus=" + hideStatus + ", createAt="
				+ createAt + ", updateAt=" + updateAt + "]";
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	
	
}