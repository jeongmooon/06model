package com.model2.mvc.service.domain;

import java.sql.Date;

public class Coupon {
	private int couponNo;
	private String userId;
	private String salePercent;
	private String useCheck;
	private String eventNum;
	private Date dueDate;
	
	public Coupon() {
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public String getSalePercent() {
		return salePercent;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setSalePercent(String salePercent) {
		this.salePercent = salePercent;
	}
	public String getUseCheck() {
		return useCheck;
	}
	public void setUseCheck(String useCheck) {
		this.useCheck = useCheck;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getEventNum() {
		return eventNum;
	}
	public void setEventNum(String eventNum) {
		this.eventNum = eventNum;
	}
	@Override
	public String toString() {
		return "Coupon [userId=" + userId + ", salePercent=" + salePercent + ", useCheck=" + useCheck + ", eventNum="
				+ eventNum + ", dueDate=" + dueDate + "]";
	}
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	
}
