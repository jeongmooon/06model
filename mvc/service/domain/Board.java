package com.model2.mvc.service.domain;

import java.sql.Date;
import java.util.List;

public class Board {
	private int boardNo;
	private String userId;
	private String boardTitle;
	private String boardContent;
	private String region;
	private int status;
	private Date createAt;
	private Date updateAt;
	private String boardCategory;
	
	// ´ñ±Û
	private List<Comment> comment;
	
	public int getBoardNo() {
		return boardNo;
	}
	public String getUserId() {
		return userId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public String getRegion() {
		return region;
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
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setRegion(String region) {
		this.region = region;
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
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userId=" + userId + ", boardTitle=" + boardTitle + ", boardContent="
				+ boardContent + ", regin=" + region + ", status=" + status + ", createAt=" + createAt + ", updateAt="
				+ updateAt + ", boardCategory=" + boardCategory + "]";
	}
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
	
}
