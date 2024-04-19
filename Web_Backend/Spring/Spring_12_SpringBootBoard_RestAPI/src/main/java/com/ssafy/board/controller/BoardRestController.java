package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-board")
@Tag(name="BoardRestController", description="게시판CRUD")
public class BoardRestController {
	private final BoardService boardService;
	
	@Autowired
	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//게시글 전체 조회
//	@GetMapping("/board")
//	public ResponseEntity<List<Board>> list(){
//		//스프링부트는 잭슨이 내재되어 있어서 
//		//객체를 자동으로 json형식으로 바꿔줌
//		List<Board> list = boardService.getBoardList();//전체조회
//		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
//	}
	//게시글 검색 조건에 따른 조회
	@GetMapping("/board")
	@Operation(summary="게시글 조회", description="게시글 조건에 따른 조회 가능")
	public ResponseEntity<?> list(@Parameter(description = "검색 조건")@ModelAttribute SearchCondition condition){
		List<Board> list = boardService.search(condition);//검색 조회
		if(list == null || list.size()==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	
	
	//게시글 상세
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id){
		Board board = boardService.readBoard(id);
		//board가 null이면 예외처리 필요 -> 404처리(해보기)
		//NoContent -> 실제 내용이 없다.
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	//게시글 등록(Form 형식으로 넘어왔을 때)
	@PostMapping("/board")
	public ResponseEntity<?> write(@ModelAttribute Board board){
		//등록한 게시글을 보냈는데
		//등록이 되었는지 확인하려고 board로 보내는 것
		//실제로는 id만 써서 보내면 된다.
		
		//insert, update, delete -> 반환값이 int형(변경된 행의 개수).
		boardService.writeBoard(board);
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	//게시글 수정
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board){
		board.setId(id);
		boardService.modifyBoard(board);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	//게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		//반환값에 따라서 실제로 지워졌는지, 존재하지 않는 글을 지우려했는지 등 상황에 따라서
		//응답코드가 바뀌면 프론트에서 처리하기가 더 수월해짐
		boardService.removeBoard(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
