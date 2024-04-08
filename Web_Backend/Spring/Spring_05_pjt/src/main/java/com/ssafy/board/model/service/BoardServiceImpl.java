package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.repository.BoardRepository;
import com.ssafy.board.model.repository.BoardRepositoryImpl;
import com.ssafy.dto.Board;

public class BoardServiceImpl implements BoardService {
	
	private static BoardService service = new BoardServiceImpl();
	//의존성 주입
	private BoardRepository repository = BoardRepositoryImpl.getInstance();
	private BoardServiceImpl() {}
	
	public static BoardService getInstance() {
		return service;
	}
	
	@Override
	public List<Board> getList() {
		return repository.SelectAll();
	}

	@Override
	public Board getBoard(int id) {
		repository.updateviewCnt(id);
		return repository.selectOne(id);
	}

	@Override
	public void writeBoard(Board board) {
		repository.insertBoard(board);

	}

	@Override
	public void modifyBoard(Board board) {
		repository.updateBoard(board);
	}

	@Override
	public void removeBoard(int id) {
		repository.deleteBoard(id);
	}

}
