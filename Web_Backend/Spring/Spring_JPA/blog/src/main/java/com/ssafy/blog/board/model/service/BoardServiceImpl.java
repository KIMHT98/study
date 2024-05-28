package com.ssafy.blog.board.model.service;

import com.ssafy.blog.board.model.Board;
import com.ssafy.blog.board.model.BoardListInfo;
import com.ssafy.blog.board.model.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public void writeArticle(Board board) throws Exception {
        boardMapper.writeArticle(board);
    }

    @Override
    public BoardListInfo listArticle(Map<String, String> map) throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("bcode", map.get("bcode"));
        param.put("word", map.get("word") == null ? "" : map.get("word"));
        int currentPage = Integer.parseInt(map.get("pgno") == null ? "1" : map.get("pgno"));
        int sizePerPage = Integer.parseInt(map.get("spp") == null ? "20" : map.get("spp"));
        int start = currentPage * sizePerPage - sizePerPage;
        param.put("start", start);
        param.put("listsize", sizePerPage);

        String key = map.get("key");
        param.put("key", key == null ? "" : key);
        if ("user_id".equals(key))
            param.put("key", key == null ? "" : "b.user_id");
        List<Board> list = boardMapper.listArticle(param);

        if ("user_id".equals(key))
            param.put("key", key == null ? "" : "user_id");
        int totalArticleCount = boardMapper.getTotalArticleCount(param);
        int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;

        BoardListInfo boardListInfo = new BoardListInfo();
        boardListInfo.setArticles(list);
        boardListInfo.setCurrentPage(currentPage);
        boardListInfo.setTotalPageCount(totalPageCount);

        return boardListInfo;
    }

    @Override
    public Board getArticle(int articleNo) throws Exception {
        return boardMapper.getArticle(articleNo);
    }

    @Override
    public void updateHit(int articleNo) throws Exception {
        boardMapper.updateHit(articleNo);
    }
}
