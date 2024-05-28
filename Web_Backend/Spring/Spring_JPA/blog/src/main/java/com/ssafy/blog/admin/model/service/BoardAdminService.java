package com.ssafy.blog.admin.model.service;

import com.ssafy.blog.admin.model.BoardList;
import com.ssafy.blog.admin.model.BoardMenus;
import com.ssafy.blog.admin.model.BoardType;
import com.ssafy.blog.admin.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BoardAdminService {

    List<Category> listCategory() throws Exception;
    void createCategory(String categoryName) throws Exception;
    List<BoardType> listBoardType() throws Exception;
    void createBoard(BoardList boardList) throws Exception;
    List<BoardMenus> listBoardMenus() throws Exception;

}
