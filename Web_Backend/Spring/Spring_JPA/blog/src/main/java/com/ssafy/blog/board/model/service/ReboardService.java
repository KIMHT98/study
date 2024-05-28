package com.ssafy.blog.board.model.service;

import com.ssafy.blog.board.model.Reboard;
import com.ssafy.blog.board.model.ReboardListInfo;

import java.util.Map;

public interface ReboardService {

    void writeArticle(Reboard reboard) throws Exception;
    void replyArticle(Reboard reboard) throws Exception;
    ReboardListInfo listArticle(Map<String, String> map) throws Exception;
    Reboard getArticle(int articleNo) throws Exception;
    void updateHit(int articleNo) throws Exception;
}
