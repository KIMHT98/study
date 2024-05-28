package com.ssafy.blog.admin.model.service;

import com.ssafy.blog.admin.model.BoardList;
import com.ssafy.blog.admin.model.BoardMenus;
import com.ssafy.blog.admin.model.BoardType;
import com.ssafy.blog.admin.model.Category;
import com.ssafy.blog.admin.model.mapper.BoardAdminMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardAdminServiceImpl implements BoardAdminService{

    private final BoardAdminMapper boardAdminMapper;

    public BoardAdminServiceImpl(BoardAdminMapper boardAdminMapper) {
        this.boardAdminMapper = boardAdminMapper;
    }

    @Override
    public List<Category> listCategory()  throws Exception{
        return boardAdminMapper.listCategory();
    }

    @Override
    public void createCategory(String categoryName) throws Exception {
        boardAdminMapper.createCategory(categoryName);
    }

    @Override
    public List<BoardType> listBoardType() throws Exception {
        return boardAdminMapper.listBoardType();
    }

    @Override
    public void createBoard(BoardList boardList) throws Exception {
        boardAdminMapper.createBoard(boardList);
    }

    @Override
    public List<BoardMenus> listBoardMenus() throws Exception {
        return boardAdminMapper.listBoardMenus();
    }
}
