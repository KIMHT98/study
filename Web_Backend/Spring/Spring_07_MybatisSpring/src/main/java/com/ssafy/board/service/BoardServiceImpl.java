package com.ssafy.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	private final BoardDao boardDao;
	
	@Autowired
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<Board> getBoardList() {
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		boardDao.updateViewCnt(id);
		return boardDao.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void modifyBoard(Board board) {
		boardDao.updateBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		boardDao.deleteBoard(id);
	}
	
	

}
