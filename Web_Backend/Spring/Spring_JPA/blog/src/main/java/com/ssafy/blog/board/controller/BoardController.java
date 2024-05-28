package com.ssafy.blog.board.controller;

import com.ssafy.blog.board.model.Board;
import com.ssafy.blog.board.model.BoardListInfo;
import com.ssafy.blog.board.model.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/article")
//@Api("게시판 컨트롤러  API V1")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //    @ApiOperation(value = "게시판 글목록", notes = "모든 게시글의 정보를 반환한다.", response = List.class)
//    @ApiResponses({ @ApiResponse(code = 200, message = "회원목록 OK!!"), @ApiResponse(code = 404, message = "페이지없어!!"),
//            @ApiResponse(code = 500, message = "서버에러!!") })
    @GetMapping
    public ResponseEntity<?> listArticle(@RequestParam Map<String, String> map) {
        log.info("listArticle map - {}", map);
        try {
            BoardListInfo boardListInfo = boardService.listArticle(map);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));
            return ResponseEntity.ok().headers(headers).body(boardListInfo);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    //    @ApiOperation(value = "게시판 글작성", notes = "새로운 게시글 정보를 입력한다.")
    @PostMapping
//    public ResponseEntity<?> writeArticle(
//            @RequestBody @ApiParam(value = "게시글 정보.", required = true) Board board) {
    public ResponseEntity<?> writeArticle(@RequestBody Board board) {
        log.info("writeArticle boardDto - {}", board);
        try {
            boardService.writeArticle(board);
//			return ResponseEntity.ok().build();
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        } catch (Exception e) {
            return exceptionHandling(e);
        }
    }

    //    @ApiOperation(value = "게시판 글보기", notes = "글번호에 해당하는 게시글의 정보를 반환한다.", response = BoardDto.class)
    @GetMapping("/{articleno}")
//    public ResponseEntity<BoardDto> getArticle(
//            @PathVariable("articleno") @ApiParam(value = "얻어올 글의 글번호.", required = true) int articleno)
//            throws Exception {
    public ResponseEntity<Board> getArticle(@PathVariable("articleno") int articleNo) throws Exception {
        log.info("getArticle - 호출 : " + articleNo);
        boardService.updateHit(articleNo);
        return new ResponseEntity<Board>(boardService.getArticle(articleNo), HttpStatus.OK);
    }

    private ResponseEntity<?> exceptionHandling(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body("[Error] : " + e.getMessage());
    }

}
