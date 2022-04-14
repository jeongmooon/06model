package com.model2.mvc.service.domain;

public class StarNum {
	private int score;
	private String userId;
	private int prodNo;
	private String review;
	private String checkB;	
	
	@Override
	public String toString() {
		return "StarNum [score=" + score + ", userId=" + userId + ", prodNo=" + prodNo + ", review=" + review
				+ ", checkB=" + checkB + "]";
	}

	public int getScore() {
		return score;
	}

	public String getUserId() {
		return userId;
	}

	public int getProdNo() {
		return prodNo;
	}

	public String getCheckB() {
		return checkB;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public void setCheckB(String checkB) {
		this.checkB = checkB;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
}
