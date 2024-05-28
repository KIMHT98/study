package com.ssafy.blog.board.model.service;

import com.ssafy.blog.board.model.Board;
import com.ssafy.blog.board.model.BoardListInfo;
import com.ssafy.blog.board.model.Reboard;
import com.ssafy.blog.board.model.ReboardListInfo;
import com.ssafy.blog.board.model.mapper.ReboardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReboardServiceImpl implements ReboardService {

    private final ReboardMapper reboardMapper;

    public ReboardServiceImpl(ReboardMapper reboardMapper) {
        this.reboardMapper = reboardMapper;
    }

    @Transactional
    @Override
    public void writeArticle(Reboard reboard) throws Exception {
        reboardMapper.writeArticle(reboard);
        reboardMapper.newReplyArticle(reboard);
    }

    @Transactional
    @Override
    public void replyArticle(Reboard reboard) throws Exception {
        reboardMapper.updateStep(reboard);
        reboardMapper.writeArticle(reboard);
        reboardMapper.replyArticle(reboard);
        reboardMapper.updateReply(reboard.getParentNo());
    }

    @Override
    public ReboardListInfo listArticle(Map<String, String> map) throws Exception {
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
        List<Reboard> list = reboardMapper.listArticle(param);

        if ("user_id".equals(key))
            param.put("key", key == null ? "" : "user_id");
        int totalArticleCount = reboardMapper.getTotalArticleCount(param);
        int totalPageCount = (totalArticleCount - 1) / sizePerPage + 1;

        ReboardListInfo reboardListInfo = new ReboardListInfo();
        reboardListInfo.setArticles(list);
        reboardListInfo.setCurrentPage(currentPage);
        reboardListInfo.setTotalPageCount(totalPageCount);

        return reboardListInfo;
    }

    @Override
    public Reboard getArticle(int articleNo) throws Exception {
        return reboardMapper.getArticle(articleNo);
    }

    @Override
    public void updateHit(int articleNo) throws Exception {
        reboardMapper.updateHit(articleNo);
    }
}
