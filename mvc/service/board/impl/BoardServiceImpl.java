package com.model2.mvc.service.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.service.board.BoardDao;
import com.model2.mvc.service.board.BoardService;
import com.model2.mvc.service.domain.Board;
import com.model2.mvc.service.domain.User;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {
	@Autowired
	@Qualifier("boardDaoImpl")
	private BoardDao boardDao;
	
	public BoardServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass());
	}
	
	@Override
	public void addBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		boardDao.addBoard(board);
	}

	@Override
	public List<Board> getBoard(User user) throws Exception {
		// TODO Auto-generated method stub
		return boardDao.getBoard(user);
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		boardDao.updateBoard(board);
	}

	@Override
	public void updateStatusBoard(Board board) throws Exception {
		// TODO Auto-generated method stub
		boardDao.updateStatusBoard(board);
	}

}
