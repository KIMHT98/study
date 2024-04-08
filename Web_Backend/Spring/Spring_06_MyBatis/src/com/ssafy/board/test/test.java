package com.ssafy.board.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MyAppSqlConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class test {
	public static void main(String[] args) {
	
//		try(SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
////			session.selectOne("경로") -> 얘의 selectOne와 아래의 selectOne은 출처가 다름
//			Board board = dao.selectOne(1);
//			System.out.println(board);
//		}
//		try(SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
//			Board board = new Board("ㅁㄴㅇㄹ","ㅁㄴㅇㄻㅇㄴㄹ","ㅁㄴㅇㄹㄴㅁㅇ");
//			dao.insertBoard(board);
//		}
//		try(SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
//			dao.deleteBoard(7);
//		}
		try(SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){
			BoardDao dao = session.getMapper(BoardDao.class);
			dao.updateViewCnt(2);
		}
		try(SqlSession session = MyAppSqlConfig.getFactory().openSession(true)){
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = dao.selectOne(1);
			board.setContent("복잡해");
			dao.updateBoard(board);
		}
		try (SqlSession session = MyAppSqlConfig.getFactory().openSession(true)) {
			List<Board> boards = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
			for (Board board : boards) {
				System.out.println(board);
			}
		}
	}
}
