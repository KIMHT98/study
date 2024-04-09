package com.ssafy.board.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

// 사용자 친화적으로
public interface BoardService {
	// 전체글 가져와
	List<Board> getBoardList();
	// 게시글 하나만
	Board readBoard(int id);
	// 게시글 작성
	void writeBoard(Board board);
	// 게시글 수정
	void modifyBoard(Board board);
	// 게시글 삭제
	void removeBoard(int id);
}
