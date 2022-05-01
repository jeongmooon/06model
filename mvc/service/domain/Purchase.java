package com.model2.mvc.service.domain;

import java.sql.Date;


public class Purchase {
	
	private int tranNo;
	private Product product;
	private User buyer;
	private int status;
	private Date createAt;
	private Date updateAt;
	
	@Override
	public String toString() {
		return "Purchase [tranNo=" + tranNo + ", product=" + product + ", buyer=" + buyer + ", status=" + status
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

	public int getTranNo() {
		return tranNo;
	}

	public Product getProduct() {
		return product;
	}

	public User getBuyer() {
		return buyer;
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

	public void setTranNo(int tranNo) {
		this.tranNo = tranNo;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
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
	
	
}