package com.ssafy.board.model.repository;

import java.util.List;

import com.ssafy.dto.Board;

public interface BoardRepository {
	public abstract List<Board> SelectAll();
	public abstract Board selectOne(int id);
	public abstract void insertBoard(Board board);
	public abstract void updateBoard(Board board);
	void deleteBoard(int id);
	void updateviewCnt(int id);
}
