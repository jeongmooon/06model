package com.model2.mvc.service.comment.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.comment.CommentDao;
import com.model2.mvc.service.domain.Comment;

@Repository("commentDaoImpl")
public class CommentDaoImpl implements CommentDao {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public CommentDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void addComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("ProductMapper.addProduct",comment);
	}

	@Override
	public void updateComment(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("ProductMapper.updateProduct",comment);
	}

	@Override
	public void updateStatusCm(Comment comment) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("ProductMapper.updateStatusComment",comment);
	}

	@Override
	public List<Comment> getComment(int boardNo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ProductMapper.getComment",boardNo);
	}
	
}
