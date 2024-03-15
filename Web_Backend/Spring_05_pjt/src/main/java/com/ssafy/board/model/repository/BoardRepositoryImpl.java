package com.ssafy.board.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.dto.Board;

public class BoardRepositoryImpl implements BoardRepository {
	//DB와 연결되어 해당 로직을 호출
	private static BoardRepository repository = new BoardRepositoryImpl();
	//메모리를 DB라고 생각하고 처리
	private List<Board> list = new ArrayList<>();//리스트 관리
	private Map<Integer, Board> boards = new HashMap<>();//맵으로 관리
	
	
	private BoardRepositoryImpl() {
		boards.put(1, new Board("SSAFY 완벽가이드", "김현태", "어렵농"));
	}
	public static BoardRepository getInstance() {
		return repository;
	}
	@Override
	public List<Board> SelectAll() {
//		return list; //리스트로 관리할 때
//		return (List<Board>)boards.values(); //맵에서 value를 가져올 때
		List<Board> tmp = new ArrayList<>();
		for(int i : boards.keySet()) {
			tmp.add(boards.get(i));
		}
		return tmp;
	}

	@Override
	public Board selectOne(int id) {
		
		return boards.get(id);
	}

	@Override
	public void insertBoard(Board board) {
		boards.put(board.getId(), board);//id=키 / board=값
		list.add(board); //리스트에 해도됨
	}

	@Override
	public void updateBoard(Board board) {
		boards.put(board.getId(), board);
	}

	@Override
	public void deleteBoard(int id) {
		boards.remove(id);
	}

	@Override
	public void updateviewCnt(int id) {
		Board b = boards.get(id);
		b.setViewCnt(b.getViewCnt()+1);
	}

}

