package com.model2.mvc.service.comment.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.comment.CommentDao;
import com.model2.mvc.service.comment.CommentService;
import com.model2.mvc.service.domain.Comment;

@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {
	@Autowired
	@Qualifier("commentDaoImpl")
	private CommentDao commentDao;
	
	public CommentServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void addComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		commentDao.addComment(comment);
	}

	@Override
	public void updateComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		commentDao.updateComment(comment);
	}

	@Override
	public void updateStatusCm(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		commentDao.updateStatusCm(comment);
	}

	@Override
	public List<Comment> getComment(int boardNo) throws Exception {
		// TODO Auto-generated method stub
		return commentDao.getComment(boardNo);
	}
	
	
}
