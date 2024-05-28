package com.ssafy.blog.board.model.mapper;

import com.ssafy.blog.board.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {

    void writeArticle(Board board) throws SQLException;
    List<Board> listArticle(Map<String, Object> param) throws SQLException;
    int getTotalArticleCount(Map<String, Object> param) throws SQLException;
    Board getArticle(int articleNo) throws SQLException;
    void updateHit(int articleNo) throws SQLException;

}
