package com.model2.mvc.service.comment;

import java.util.List;

import com.model2.mvc.service.domain.Comment;

public interface CommentService {
	public void addComment(Comment comment) throws Exception;
	public void updateComment(Comment comment) throws Exception;
	public void updateStatusCm(Comment comment) throws Exception;
	public List<Comment> getComment(int boardNo) throws Exception;
}
