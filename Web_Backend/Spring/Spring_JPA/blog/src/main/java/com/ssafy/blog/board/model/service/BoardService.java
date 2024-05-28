package com.ssafy.blog.board.model.service;

import com.ssafy.blog.board.model.Board;
import com.ssafy.blog.board.model.BoardListInfo;

import java.util.Map;

public interface BoardService {

    void writeArticle(Board board) throws Exception;
    BoardListInfo listArticle(Map<String, String> map) throws Exception;
    Board getArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;

}
