package com.model2.mvc.service.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.service.board.BoardDao;
import com.model2.mvc.service.domain.Board;
import com.model2.mvc.service.domain.User;

@Repository("boardDaoImpl")
public class BoardDaoImpl implements BoardDao {
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public BoardDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void addBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("BoardMapper.addBoard",board);
	}

	@Override
	public List<Board> getBoard(User user) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BoardMapper.getBoard",user);
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("BoardMapper.updateBoard",board);
	}
	
	@Override
	public void updateStatusBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("BoardMapper.updateStatusBoard",board);
	}
}
