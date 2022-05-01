package com.model2.mvc.service.board;

import java.util.List;

import com.model2.mvc.service.domain.Board;
import com.model2.mvc.service.domain.User;

public interface BoardDao {
	public void addBoard(Board board) throws Exception;
	public List<Board> getBoard(User user) throws Exception;
	public void updateBoard(Board board) throws Exception;
	public void updateStatusBoard(Board board) throws Exception;
}
