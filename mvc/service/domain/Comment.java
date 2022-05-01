package com.model2.mvc.service.domain;

import java.sql.Date;

public class Comment {
	private int bcNo;
	private String userId;
	private int boardNo;
	private String contents;
	private int commnetGroup;
	private int cmlayer;
	private Date createAt;
	private Date updateAt;
	private int status;
	
	public int getBcNo() {
		return bcNo;
	}
	public String getUserId() {
		return userId;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public String getContents() {
		return contents;
	}
	public int getCommnetGroup() {
		return commnetGroup;
	}
	public int getCmlayer() {
		return cmlayer;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public int getStatus() {
		return status;
	}
	public void setBcNo(int bcNo) {
		this.bcNo = bcNo;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setCommnetGroup(int commnetGroup) {
		this.commnetGroup = commnetGroup;
	}
	public void setCmlayer(int cmlayer) {
		this.cmlayer = cmlayer;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Comment [bcNo=" + bcNo + ", userId=" + userId + ", boardNo=" + boardNo + ", contents=" + contents
				+ ", commnetGroup=" + commnetGroup + ", cmlayer=" + cmlayer + ", createAt=" + createAt + ", updateAt="
				+ updateAt + ", status=" + status + "]";
	}
	
}
