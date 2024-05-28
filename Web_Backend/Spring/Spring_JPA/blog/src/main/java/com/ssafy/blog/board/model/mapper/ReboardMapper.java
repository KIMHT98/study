package com.ssafy.blog.board.model.mapper;

import com.ssafy.blog.board.model.Board;
import com.ssafy.blog.board.model.Reboard;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReboardMapper {

    void newWriteArticle(Reboard reboard) throws SQLException;
    void newReplyArticle(Reboard reboard) throws SQLException;

    void updateStep(Reboard reboard) throws SQLException;
    void writeArticle(Reboard reboard) throws SQLException;
    void replyArticle(Reboard reboard) throws SQLException;
    void updateReply(int parentNo) throws SQLException;


    List<Reboard> listArticle(Map<String, Object> param) throws SQLException;
    int getTotalArticleCount(Map<String, Object> param) throws SQLException;
    Reboard getArticle(int articleNo) throws SQLException;
    void updateHit(int articleNo) throws SQLException;

}
